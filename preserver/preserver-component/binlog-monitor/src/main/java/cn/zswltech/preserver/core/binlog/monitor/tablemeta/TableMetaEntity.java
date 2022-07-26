package cn.zswltech.preserver.core.binlog.monitor.tablemeta;

import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TableMetaEntity {
    private SyncConfig syncConfig;
    private Long tableId;
    private String dbName;
    private String tableName;
    private List<ColumnMetaData> columnMetaDataList = new ArrayList<ColumnMetaData>();
    private List<ColumnMetaData> key = new ArrayList<>();
    private String createSql;

    @Data
    public static class ColumnMetaData {
        String name;
        String type;
    }
}
