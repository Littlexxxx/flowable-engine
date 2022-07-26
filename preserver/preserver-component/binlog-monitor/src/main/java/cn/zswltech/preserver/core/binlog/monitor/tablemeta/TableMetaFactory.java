package cn.zswltech.preserver.core.binlog.monitor.tablemeta;



import cn.zswltech.preserver.core.binlog.monitor.config.SyncConfig;
import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class TableMetaFactory {
    SyncConfig syncConfig;

    public TableMetaFactory(SyncConfig syncConfig) {
        this.syncConfig = syncConfig;
    }

    //缓存tableId信息
    private Map<Long, TableMetaEntity> tableMetaEntityIdMap = new HashMap<>();
    //缓存表名信息
    private Map<String, TableMetaEntity> tableMetaEntityNameMap = new HashMap<>();

    public TableMetaEntity getTableMetaEntity(Long tableId, String dbName, String tableName) throws BinlogMonitorRuntimeException {
        Connection connection = null;
        try {
            if (tableMetaEntityIdMap.get(tableId) != null) {
                return tableMetaEntityIdMap.get(tableId);
            } else {
                String url = "jdbc:mysql://" + syncConfig.getHost() + ":" + syncConfig.getPort() + "/" + dbName;
                connection = DriverManager.getConnection(url, syncConfig.getUserName(), syncConfig.getPassword());
                DatabaseMetaData dbmd = connection.getMetaData();
                ResultSet rs = dbmd.getColumns(dbName, dbName, tableName, null);
                ResultSet keyRs = dbmd.getPrimaryKeys(null,null,tableName);
                TableMetaEntity tableMetaEntity = new TableMetaEntity();
                tableMetaEntity.setTableId(tableId);
                tableMetaEntity.setDbName(dbName);
                tableMetaEntity.setTableName(tableName);
                tableMetaEntity.setSyncConfig(syncConfig);
                while (rs.next()) {
                    TableMetaEntity.ColumnMetaData columnMetaData = new TableMetaEntity.ColumnMetaData();
                    String colName = rs.getString("COLUMN_NAME");
                    columnMetaData.setName(colName);
                    String dbType = rs.getString("TYPE_NAME");
                    columnMetaData.setType(dbType);
                    tableMetaEntity.getColumnMetaDataList().add(columnMetaData);
                }
                while (keyRs.next()){
                    TableMetaEntity.ColumnMetaData keyMetaData = new TableMetaEntity.ColumnMetaData();
                    String colName = keyRs.getString("COLUMN_NAME");
                    keyMetaData.setName(colName);
                    tableMetaEntity.getKey().add(keyMetaData);
                }
                tableMetaEntityIdMap.put(tableId, tableMetaEntity);
                return tableMetaEntity;
            }
        } catch (Throwable e) {
            throw new BinlogMonitorRuntimeException(e.getCause());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    /**
     * 根据tableId获取表元数据
     *
     * @param tableId
     * @return
     */
    public TableMetaEntity getTableMetaEntity(Long tableId) {
        return tableMetaEntityIdMap.get(tableId);
    }
}
