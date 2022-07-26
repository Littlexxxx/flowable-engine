package cn.zswltech.preserver.core.binlog.monitor.event.parser;

import cn.zswltech.preserver.core.binlog.monitor.event.EventEntity;
import cn.zswltech.preserver.core.binlog.monitor.event.EventEntityType;
import cn.zswltech.preserver.core.binlog.monitor.event.parser.converter.CommonConverterProcessor;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;
import cn.zswltech.preserver.core.binlog.monitor.tablemeta.TableMetaEntity;
import cn.zswltech.preserver.core.binlog.monitor.tablemeta.TableMetaFactory;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InsertEventParser implements IEventParser {
    CommonConverterProcessor commonConverterProcessor = new CommonConverterProcessor();

    TableMetaFactory tableMetaFactory;

    public InsertEventParser(TableMetaFactory tableMetaFactory) {
        this.tableMetaFactory = tableMetaFactory;
    }

    @Override
    public List<EventEntity> parse(Event event) throws BinlogMonitorRuntimeException {
        WriteRowsEventData writeRowsEventData = event.getData();
        TableMetaEntity tableMetaEntity = tableMetaFactory.getTableMetaEntity(writeRowsEventData.getTableId());
        List<Serializable[]> rows = writeRowsEventData.getRows();
        List<EventEntity> eventEntityList = new ArrayList<>();
        rows.forEach(rowMap -> {
            List<TableMetaEntity.ColumnMetaData> columnMetaDataList = tableMetaEntity.getColumnMetaDataList();
            String[] after = commonConverterProcessor.convertToString(rowMap, columnMetaDataList);
            List<String> columns = new ArrayList<>();
            List<Object> changeAfter = new ArrayList<>();
            for (int i = 0; i < after.length; i++) {
                columns.add(columnMetaDataList.get(i).getName());
                changeAfter.add(after[i]);
            }

            EventEntity eventEntity = new EventEntity();
            eventEntity.setEvent(event);
            eventEntity.setEventEntityType(EventEntityType.INSERT);
            eventEntity.setDatabaseName(tableMetaEntity.getDbName());
            eventEntity.setTableName(tableMetaEntity.getTableName());
            eventEntity.setColumns(columnMetaDataList);
            eventEntity.setKeys(tableMetaEntity.getKey());
            eventEntity.setChangeAfter(changeAfter);
            eventEntity.setSyncConfig(tableMetaEntity.getSyncConfig());
            eventEntityList.add(eventEntity);
        });
        return eventEntityList;
    }
}
