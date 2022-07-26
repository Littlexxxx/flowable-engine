package cn.zswltech.preserver.core.binlog.monitor.config;

import cn.zswltech.preserver.core.binlog.monitor.event.handler.IEventHandler;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/20 4:30 下午
 * @description:
 **/
@Data
public class SyncConfig {
    String host;
    Integer port;
    String userName;
    String password;
    List<IEventHandler> eventHandlerList = new ArrayList<>();

    public SyncConfig() {
    }

    public SyncConfig(String host, Integer port, String userName, String password) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public void addEventHandlerList(IEventHandler eventHandler) {
        eventHandlerList.add(eventHandler);
    }

    @Override
    public String toString() {
        return "SyncConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
