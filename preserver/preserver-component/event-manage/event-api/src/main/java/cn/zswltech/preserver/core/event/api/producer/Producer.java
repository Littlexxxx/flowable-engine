package cn.zswltech.preserver.core.event.api.producer;

import java.util.Map;

public interface Producer {
    void produce(String messageKey, byte[] message, Map<String, String> attributes) throws Exception;
}