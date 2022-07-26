package cn.zswltech.preserver.core.binlog.monitor;

import cn.zswltech.preserver.core.binlog.monitor.config.BinlogMonitorConfig;
import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;
import cn.zswltech.preserver.core.binlog.monitor.factory.BinaryLogClientFactory;
import com.github.shyiko.mysql.binlog.BinaryLogClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/23 2:17 下午
 * @description:
 **/
@Component
public class BinlogClientStarter {
    private final Logger log = LoggerFactory.getLogger(BinlogClientStarter.class);

    @Autowired
    private BinaryLogClientFactory binaryLogClientFactory;

    @Autowired
    private BinlogMonitorConfig binlogMonitorConfig;

    /**
     * main start method
     */
    public void start() throws BinlogMonitorRuntimeException {
        startAll();
    }

    private void startAll() {

        //生成全部client
        List<BinaryLogClient> binaryLogClientList = new ArrayList<>();
        binlogMonitorConfig.getSyncConfigList().forEach((key, syncConfig) -> {
            try {
                binaryLogClientList.add(binaryLogClientFactory.getClient(syncConfig));
            } catch (BinlogMonitorRuntimeException e) {
                log.error(e.getMessage(), e);
            }
        });

        //执行
        binaryLogClientList.forEach(binaryLogClient -> {
            new Thread(() -> {
                try {
                    binaryLogClient.setHeartbeatInterval(10 * 1000L);
                    binaryLogClient.connect();
                } catch (IOException e) {
                    log.error("binaryLogClient connect error!" + binaryLogClient.toString());
                }
            }).start();
        });
    }

    public BinaryLogClient getClientByDbKey(String key) {
        SyncConfig syncConfig = binlogMonitorConfig.getSyncConfigList().get(key);
        if (syncConfig == null) {
            return null;
        }
        return binaryLogClientFactory.getCachedClient(syncConfig);
    }

    public void start(SyncConfig syncConfig){
        BinaryLogClient client = binaryLogClientFactory.getClient(syncConfig);
        new Thread(() -> {
            try {
                client.setHeartbeatInterval(10 * 1000L);
                client.connect();
            } catch (IOException e) {
                log.error("binaryLogClient connect error!" + client.toString());
            }
        },"test").start();
    }

    public void exit(SyncConfig syncConfig){
        BinaryLogClient client = binaryLogClientFactory.getClient(syncConfig);
    }
}
