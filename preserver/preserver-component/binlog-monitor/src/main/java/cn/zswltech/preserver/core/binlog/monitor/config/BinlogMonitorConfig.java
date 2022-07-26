package cn.zswltech.preserver.core.binlog.monitor.config;


import cn.zswltech.preserver.core.binlog.monitor.position.IPositionHandler;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
@Component
public class BinlogMonitorConfig {
    //配置列表
    Map<String, SyncConfig> syncConfigList = new HashMap<>();

    //增加配置项
    public void addSyncConfig(String key, SyncConfig syncConfig) {
        syncConfigList.put(key, syncConfig);
    }

}
