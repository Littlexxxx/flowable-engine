package cn.zswltech.preserver.core.event.mysql.consumer;

import java.util.Date;

import cn.zswltech.preserver.core.event.api.consumer.AbstractDomainEventRepository;
import cn.zswltech.preserver.core.event.api.consumer.DomainEvent;
import cn.zswltech.preserver.core.event.mysql.orm.DomainEventDO;
import cn.zswltech.preserver.core.event.mysql.orm.DomainEventMapper;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * @author liujian
 * @date 2021/9/1 7:22 下午
 */
@Component
public class DomainEventRepositoryImpl extends AbstractDomainEventRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomainEventRepositoryImpl.class);

    @Autowired
    private DomainEventMapper domainEventDOMapper;

    @Value("${event.retry.max.times:3}")
    private Integer retryMaxTimes;

    @Value("${event.retry.list.max.size:1000}")
    private Integer retryListMaxSize;

    private static Long startId = 0L;

    /**
     * id初始化为前几分钟的最小id,防止load完毕后reload的id初始化有一定时延
     */
    private static final int LAST_MINUTES = 2;

    private static Date lastDate = null;

    /**
     * 重试的消息：键值为实体类型加实体的uuid来标识
     */
    private final Map<String,RetryEvent> retryList = new ConcurrentHashMap<>();

    @Override
    protected void init() {
        if (lastDate == null){
            lastDate = DateUtils.addMinutes(new Date(),-LAST_MINUTES);
        }
        startId = domainEventDOMapper.minIdAfterGmtModify(lastDate);
        if (startId == null){
            startId = 0L;
        }
        super.init();
    }

    @Override
    protected List<DomainEvent> pullLastestNotice0() {
        try{
            List<DomainEventDO> domainEventDOS = domainEventDOMapper.query(startId);
            if (domainEventDOS == null){
                domainEventDOS = new ArrayList<>();
            }
            AtomicLong id = new AtomicLong(startId);
            List<DomainEvent> eventList = domainEventDOS.stream()
                    .map(domainEventDO -> {
                        id.set(Math.max(id.get(), domainEventDO.getId()));
                        //清除重试中旧消息
                        if (!retryList.isEmpty() && retryList.containsKey(domainEventDO.getEntity() + domainEventDO.getUuid())){
                            if (retryList.get(domainEventDO.getEntity() + domainEventDO.getUuid())
                                    .getEvent().getOccurredTime().compareTo(domainEventDO.getGmtCreate().getTime()) <= 0){
                                retryList.remove(domainEventDO.getEntity() + domainEventDO.getUuid());
                            }
                        }
                        return parseEvent(domainEventDO);
                    }).collect(Collectors.toList());
            startId = id.get();
            if (!retryList.isEmpty()){
                //插入重试的数据
                retryList.forEach((k,v) -> {
                    eventList.add(v.getEvent());
                });
            }
            return deduplication(eventList);
        }catch (Exception e){
            LOGGER.error("[DomainEventRepository]pull notice from repository error",e);
        }
        return new ArrayList<>();
    }

    private DomainEvent parseEvent(DomainEventDO domainEventDO) {
        DomainEvent domainEvent = new DomainEvent();
        domainEvent.setOccurredTime(domainEventDO.getOccurredTime());
        domainEvent.setEntityType(domainEventDO.getEntity());
        domainEvent.setEntityUuid(domainEventDO.getEntityUuid());
        domainEvent.setEventType(domainEventDO.getEventType());
        String data = domainEventDO.getEventData();
        if (StringUtils.isBlank(data)){
            domainEvent.setEventData(new ArrayList<>());
        }else {
            JSONObject eventData = JSONObject.parseObject(data);
            JSONArray jsonArray = eventData.getJSONArray(KEY_DATA);
            if(jsonArray == null || jsonArray.isEmpty()){
                domainEvent.setEventData(new ArrayList<>());
            }else{
                domainEvent.setEventData(jsonArray.toJavaList(String.class));
            }
        }
        return domainEvent;
    }

    @Override
    public boolean needRetry() {
        return true;
    }

    @Override
    public void retry(DomainEvent domainEvent) {
        RetryEvent retryEvent = retryList.get(domainEvent.getEntityType() + domainEvent.getEntityUuid());
        if (retryEvent == null){
            if (retryList.size() <= retryListMaxSize){
                retryList.put(domainEvent.getEntityType(), new RetryEvent(domainEvent, 1));
            }else{
                LOGGER.error("领域事件:实体类型{},事件类型{},实体uuid{},重试队列超过最大值{}次"
                    ,domainEvent.getEntityType(),domainEvent.getEventType(),domainEvent.getEntityUuid(),retryListMaxSize);
            }
        }else if (retryEvent.getEvent().getOccurredTime().compareTo(domainEvent.getOccurredTime()) == 0 && retryEvent.retryTimes.get() >= retryMaxTimes){
            LOGGER.error("领域事件:实体类型{},事件类型{},实体uuid{},重试超过{}次"
                    ,domainEvent.getEntityType(),domainEvent.getEventType(),domainEvent.getEntityUuid(),retryMaxTimes);
            retryList.remove(domainEvent.getEntityType() + domainEvent.getEntityUuid());
        }else if (retryEvent.getEvent().getOccurredTime().compareTo(domainEvent.getOccurredTime()) < 0){
            //重复旧消息重置重试次数
            retryList.remove(domainEvent.getEntityType() + domainEvent.getEntityUuid());
            retryList.put(domainEvent.getEntityType() + domainEvent.getEntityUuid(), new RetryEvent(domainEvent, 1));
        }else if(retryEvent.getEvent().getOccurredTime().compareTo(domainEvent.getOccurredTime()) == 0 && retryEvent.retryTimes.get() < retryMaxTimes){
            retryEvent.retryTimes.addAndGet(1);
        }else if (retryEvent.getEvent().getOccurredTime().compareTo(domainEvent.getOccurredTime()) > 0){
            //旧消息跳过
        }
    }

    @Data
    private static class RetryEvent{

        private DomainEvent event;

        private AtomicInteger retryTimes;

        RetryEvent(DomainEvent event, Integer retryTimes){
            this.event = event;
            this.retryTimes = new AtomicInteger(retryTimes);
        }
    }
}
