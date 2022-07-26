package cn.zswltech.preserver.core.binlog.monitor.event.handler;


import cn.zswltech.preserver.core.binlog.monitor.event.EventEntity;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;

public interface IEventHandler {
    public void process(EventEntity eventEntity) throws BinlogMonitorRuntimeException;
}
