package cn.zswltech.preserver.core.binlog.monitor.event.lifecycle;

import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import org.springframework.stereotype.Component;

@Component
public class BaseLifeCycleListenerFactory {

    public BinaryLogClient.LifecycleListener getLifeCycleListener(SyncConfig syncConfig) {
        return new BaseLifeCycleEventListener(syncConfig);
    }
}