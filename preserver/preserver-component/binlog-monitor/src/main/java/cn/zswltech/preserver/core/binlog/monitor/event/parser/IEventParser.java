package cn.zswltech.preserver.core.binlog.monitor.event.parser;

import cn.zswltech.preserver.core.binlog.monitor.event.EventEntity;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;
import com.github.shyiko.mysql.binlog.event.Event;


import java.util.List;

/**
 * 事件解析器接口
 */
public interface IEventParser {
    List<EventEntity> parse(Event event) throws BinlogMonitorRuntimeException;
}
