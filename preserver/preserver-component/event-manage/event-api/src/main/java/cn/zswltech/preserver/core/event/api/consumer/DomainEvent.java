package cn.zswltech.preserver.core.event.api.consumer;

import lombok.Data;

import java.util.List;

/**
 * @author liujian
 * @date 2021/9/11 3:14 下午
 */
@Data
public class DomainEvent {

    private Long occurredTime;

    private String entityType;

    private String entityUuid;

    private String eventType;

    private List<String> eventData;

    private Class entityClass;
}
