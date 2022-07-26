package cn.zswltech.preserver.core.binlog.monitor.position;


import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;

/**
 * 处理binlog位点信息接口，实现该接口创建自定义位点处理类
 */
public interface IPositionHandler {
    BinlogPositionEntity getPosition(SyncConfig syncConfig) throws BinlogMonitorRuntimeException;

    void savePosition(SyncConfig syncConfig, BinlogPositionEntity binlogPositionEntity) throws BinlogMonitorRuntimeException;
}
