package cn.zswltech.preserver.core.event.mysql.producer;


import cn.zswltech.preserver.core.event.api.producer.Producer;
import cn.zswltech.preserver.core.event.mysql.orm.DomainEventDO;
import cn.zswltech.preserver.core.event.mysql.orm.DomainEventMapper;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;


@Component
public class MysqlProducer implements Producer {

    private static final Logger log = LoggerFactory.getLogger(MysqlProducer.class);

    @Autowired
    private DomainEventMapper domainEventDOMapper;

    @Override
    public void produce(String messageKey, byte[] message, Map<String, String> attributes) throws Exception {
        log.warn("MysqlProducer produce start.................................");
        Validate.notEmpty(attributes);
        log.warn("MysqlProducer produce attributes={}, message={}", JSONObject.toJSONString(attributes), new String(message, StandardCharsets.UTF_8));
        produce0(message, attributes);
    }


    private void produce0(byte[] message, Map<String, String> attributes) {
        DomainEventDO domainEventDO = new DomainEventDO();
        domainEventDO.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        domainEventDO.setEntity(attributes.get("entityType"));
        domainEventDO.setEventType(attributes.get("eventType"));
        domainEventDO.setEntityUuid(attributes.get("entityUuid"));
        domainEventDO.setOccurredTime(Long.valueOf(attributes.get("occurredTime")));
        String eventData = new String(message, StandardCharsets.UTF_8);
        log.warn("MysqlProducer produce domainEventDO={}, eventData={}", JSONObject.toJSONString(domainEventDO), eventData);
        domainEventDO.setEventData(eventData);

        String operator = attributes.get("operator");
        if (StringUtils.isBlank(operator)) {
            operator = "sys";
        }
        domainEventDO.setCreator(operator);
        domainEventDO.setOperator(operator);

        log.warn("MysqlProducer produce end............................domainEventDO={}", JSONObject.toJSONString(domainEventDO));
        domainEventDOMapper.insertSelective(domainEventDO);
    }
}
