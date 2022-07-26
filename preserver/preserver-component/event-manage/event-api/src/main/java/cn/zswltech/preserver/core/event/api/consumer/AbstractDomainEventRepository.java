package cn.zswltech.preserver.core.event.api.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author liujian
 * @date 2021/9/1 11:28 上午
 */
public abstract class AbstractDomainEventRepository implements DomainEventRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDomainEventRepository.class);

    private boolean initFlag = false;

    protected static final String KEY_DATA = "data";
    /**
     * 初始化
     */
    protected void init(){
        initFlag = true;
    }

    @Override
    public List<DomainEvent> pullLastestNotice() {
        if (!initFlag){
            init();
        }
        return pullLastestNotice0();
    }

    @Override
    public void putNotice(DomainEvent domainEvent) {
        throw new RuntimeException("putNotice not support");
    }

    @Override
    public boolean needRetry() {
        return false;
    }

    @Override
    public void retry(DomainEvent eventMsg) {
        throw new RuntimeException("retry not support");
    }

    /**
     * 获取消息的实现
     * @return 消息list
     */
    protected abstract List<DomainEvent> pullLastestNotice0();

    /**
     * 事件数据去重，对于同一领域的同一事件处理类型做去重
     * 批量操作需要做拆分
     * @param eventList 事件初始列表
     * @return 去重后的列表
     */
    protected List<DomainEvent> deduplication(List<DomainEvent> eventList){
        if (eventList == null || eventList.isEmpty()){
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("[DomainEvent]领域消息集合为空");
            }
            return new ArrayList<>();
        }

        Map<String, DomainEvent> target = new HashMap<>(16);
        for(DomainEvent eventMsg : eventList){

            if(eventMsg.getEventData() == null || eventMsg.getEventData().isEmpty()){
                if(!target.containsKey(eventMsg.getEntityUuid()) || isLastest(eventMsg,target.get(eventMsg.getEntityUuid()))){
                    target.put(eventMsg.getEntityUuid(), eventMsg);
                }
            }else{
                //事件拆分与处理
                for(String data :eventMsg.getEventData()) {
                    if(!target.containsKey(eventMsg.getEntityUuid()) || isLastest(eventMsg,target.get(eventMsg.getEntityUuid()))){
                        List<String> targetDatas = new ArrayList<>();
                        targetDatas.add(data);
                        eventMsg.setEventData(targetDatas);
                        target.put(eventMsg.getEntityUuid(), eventMsg);
                    }
                }
            }
        }
        return new ArrayList<>(target.values());
    }

    protected boolean isLastest(DomainEvent newVal, DomainEvent oldVal){
        Long newTime,oldTime;
        if (newVal.getOccurredTime() == null || (newTime = newVal.getOccurredTime()) == null){
            return false;
        }
        if(oldVal.getOccurredTime() == null || (oldTime = oldVal.getOccurredTime()) == null){
            return true;
        }
        return newTime > oldTime;
    }
}
