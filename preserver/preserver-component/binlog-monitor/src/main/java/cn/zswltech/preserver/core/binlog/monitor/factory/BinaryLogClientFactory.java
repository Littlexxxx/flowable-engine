package cn.zswltech.preserver.core.binlog.monitor.factory;

import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import cn.zswltech.preserver.core.binlog.monitor.event.MultiEventHandlerListener;
import cn.zswltech.preserver.core.binlog.monitor.event.lifecycle.BaseLifeCycleEventListener;
import cn.zswltech.preserver.core.binlog.monitor.event.lifecycle.BaseLifeCycleListenerFactory;
import cn.zswltech.preserver.core.binlog.monitor.event.parser.EventParserFactory;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;
import cn.zswltech.preserver.core.binlog.monitor.position.BinlogPositionEntity;
import cn.zswltech.preserver.core.binlog.monitor.position.IPositionHandler;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.security.SecureRandom;
import java.util.concurrent.ConcurrentHashMap;

/**
 * BinaryLogClient Factory
 */
@Component
public class BinaryLogClientFactory {

    private ConcurrentHashMap<String, BinaryLogClient> cache = new ConcurrentHashMap<>();

    @Autowired
    private IPositionHandler positionHandler;

    //LifeCycleEvent监听器
    @Autowired
    private BaseLifeCycleListenerFactory lifeCycleListenerFactory;

    public ConcurrentHashMap<String, BinaryLogClient> getCache() {
        return cache;
    }

    public void setCache(ConcurrentHashMap<String, BinaryLogClient> cache) {
        this.cache = cache;
    }

    /**
     * 获取客户端
     *
     * @param syncConfig SyncConfig
     * @return BinaryLogClient
     */
    public BinaryLogClient getClient(SyncConfig syncConfig) throws BinlogMonitorRuntimeException {
        String key = syncConfig.toString();
        //有缓存拿缓存里的
        if (cache.get(key) != null) {
            return cache.get(key);
        } else {
            //创建客户端
            BinaryLogClient client = new BinaryLogClient(
                    syncConfig.getHost(),
                    syncConfig.getPort(),
                    syncConfig.getUserName(),
                    syncConfig.getPassword()
            );
            EventDeserializer eventDeserializer = new EventDeserializer();
            eventDeserializer.setCompatibilityMode(
                    EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                    EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
            );
            client.setEventDeserializer(eventDeserializer);
            //设置slave的serverId，不同集群中，两个机器不能相同
            client.setServerId(getRandomServerId());

            //处理binlog位点信息
            if (positionHandler != null && positionHandler.getPosition(syncConfig) != null) {
                BinlogPositionEntity positionEntity = positionHandler.getPosition(syncConfig);
                if (positionEntity != null
                        && !StringUtils.isBlank(positionEntity.getBinlogName())
                        && positionEntity.getPosition() != null) {
                    client.setBinlogFilename(positionEntity.getBinlogName());
                    long position = positionEntity.getPosition() != null ? positionEntity.getPosition() : 0L;
                    client.setBinlogPosition((position));
                }
            }

            //创建多事件统一处理器
            MultiEventHandlerListener multiEventHandlerListener = new MultiEventHandlerListener();
            //设置事件解析器
            multiEventHandlerListener.setEventParserDispatcher(EventParserFactory.getEventParserDispatcher(syncConfig));
            //保存配置信息
            multiEventHandlerListener.setSyncConfig(syncConfig);
            //设置binlog位点信息
            multiEventHandlerListener.setPositionHandler(positionHandler);
            //注册配置信息中的事件处理器
            syncConfig.getEventHandlerList().forEach(multiEventHandlerListener::registerEventHandler);

            //注册client的监听器
            client.registerEventListener(multiEventHandlerListener);
            client.registerLifecycleListener(lifeCycleListenerFactory.getLifeCycleListener(syncConfig));

            cache.put(key, client);
            return client;
        }
    }

    public BinaryLogClient getCachedClient(SyncConfig syncConfig) {
        String key = syncConfig.toString();
        return cache.get(key);
    }


    private long getRandomServerId() {
        try {
            return new SecureRandom().nextLong();
        } catch (Throwable e) {
            return RandomUtils.nextLong();
        }
    }
}
