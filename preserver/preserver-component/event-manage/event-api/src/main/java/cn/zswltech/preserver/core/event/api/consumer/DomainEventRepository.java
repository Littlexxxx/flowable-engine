package cn.zswltech.preserver.core.event.api.consumer;

import java.util.List;

/**
 * @author liujian
 * @date 2021/9/1 11:26 上午
 */
public interface DomainEventRepository {


    /**
     * 从资源库中拉取最新的变更消息
     */
    List<DomainEvent> pullLastestNotice();

    /**
     * 存入消息到资源库中，用以支持额外消息资源库(或实现重试机制)
     * @param domainEvent 消息体
     */
    void putNotice(DomainEvent domainEvent);

    boolean needRetry();

    void retry(DomainEvent domainEvent);

}
