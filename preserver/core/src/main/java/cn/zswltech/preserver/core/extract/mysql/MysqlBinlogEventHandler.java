//package cn.zswltech.preserver.core.extract.mysql;
//
//import cn.zswltech.preserver.core.binlog.monitor.event.EventEntity;
//import cn.zswltech.preserver.core.binlog.monitor.event.handler.IEventHandler;
//import cn.zswltech.preserver.core.binlog.monitor.exception.BinlogMonitorRuntimeException;
//
//import cn.zswltech.preserver.core.binlog.monitor.tablemeta.TableMetaEntity;
//import cn.zswltech.preserver.core.datasource.impl.mysql.MysqlDataSourceImpl;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
///**
// * @author: xinhao.hu
// * @date: 2022/5/23 4:49 下午
// * @description:
// **/
//@Component
//public class MysqlBinlogEventHandler implements IEventHandler {
//
//    @Autowired
//    private MysqlDataSourceImpl mysqlDataSourceImpl;
//
//    @Override
//    public void process(EventEntity eventEntity) throws BinlogMonitorRuntimeException {
//        switch (eventEntity.getEventEntityType()){
//            case UPDATE:
//                update(eventEntity);
//                break;
//            case DELETE:
//                delete(eventEntity);
//                break;
//            case INSERT:
//                insert(eventEntity);
//                break;
//            default:
//                break;
//        }
//    }
//
////    private void update(EventEntity eventEntity){
////
////    }
////
////    private void delete(EventEntity eventEntity){
////
////    }
////
////    private void insert(EventEntity eventEntity){
////
////    }
//
//    private void update(EventEntity eventEntity){
//        JdbcTemplate jdbcTemplate = getJdbcTemplate(eventEntity);
//        Map<TableMetaEntity.ColumnMetaData,ChangeData> changeDatas = getChangeDatas(eventEntity);
//        // build change sql
//        List<String> changeNames = changeDatas.entrySet().stream()
//                .filter(t->t.getValue().isChange())
//                .map(t -> t.getKey().getName())
//                .collect(Collectors.toList());
//        String changeSql = "";
//        for(String columnMetaData : changeNames){
//            changeSql += "`"+columnMetaData+"`" + " = ?,";
//        }
//        changeSql = changeSql.substring(0,changeSql.length()-1);
//
//        // build key
//        String key = getKey(eventEntity);
//        String sql = String.format("update `%s` set %s where %s",eventEntity.getDatabaseName(),changeSql,key);
//        // build args
//        List<Object> list = new ArrayList<>();
//        for(Map.Entry<TableMetaEntity.ColumnMetaData,ChangeData> changeDataEntry: changeDatas.entrySet()){
//            list.add(getMysqlFieldType(changeDataEntry.getKey().getType(),changeDataEntry.getValue().getDateAfter()));
//        }
//        // key args , 主键在dataBefore
//        Map<String,String> beforeValueMap = changeDatas.entrySet().stream()
//                .collect(Collectors.toMap(t->t.getKey().getName(),t->t.getValue().getDataBefore()));
//        for (TableMetaEntity.ColumnMetaData pk : eventEntity.getKeys()){
//            list.add(getMysqlFieldType(pk.getName(), beforeValueMap.get(pk)));
//        }
//        jdbcTemplate.update(sql,list.toArray());
//    }
//
//    private void insert(EventEntity eventEntity){
//        JdbcTemplate jdbcTemplate = getJdbcTemplate(eventEntity);
//        Map<TableMetaEntity.ColumnMetaData,ChangeData> changeDatas = getChangeDatas(eventEntity);
//        // build sql
//        String metaDatas = "";
//        String values = "";
//        for (TableMetaEntity.ColumnMetaData columnMetaData : changeDatas.keySet()) {
//            metaDatas += "`"+columnMetaData.getName()+"`" + ",";
//            values += "?,";
//        }
//        metaDatas = metaDatas.substring(0,metaDatas.length()-1);
//        values = values.substring(0,values.length()-1);
//        String sql = String.format("inser into `%s` (%s) values (%s);",eventEntity.getTableName(),metaDatas,values);
//        // build args 参数在dataAfter
//        List<Object> list = new ArrayList<>();
//        for(Map.Entry<TableMetaEntity.ColumnMetaData,ChangeData> data : changeDatas.entrySet()){
//            list.add(getMysqlFieldType(data.getKey().getName(),data.getValue().getDateAfter()));
//        }
//        jdbcTemplate.update(sql,list.toArray());
//    }
//
//    private void delete(EventEntity eventEntity){
//        JdbcTemplate jdbcTemplate = getJdbcTemplate(eventEntity);
//        Map<TableMetaEntity.ColumnMetaData,ChangeData> changeDatas = getChangeDatas(eventEntity);
//        String key = getKey(eventEntity);
//        String sql = String.format("delete from `%s` where %s;",eventEntity.getTableName(),key);
//        // key args
//        List<Object> list = new ArrayList<>();
//        Map<String,String> keys = changeDatas.entrySet().stream()
//                .collect(Collectors.toMap(k->k.getKey().getName(),k->k.getValue().getDateAfter()));
//        for (TableMetaEntity.ColumnMetaData pk : eventEntity.getKeys()){
//            list.add(getMysqlFieldType(pk.getName(), keys.get(pk)));
//        }
//        jdbcTemplate.update(sql,list.toArray());
//    }
//
//    private DataSource buildDataSource(EventEntity eventEntity){
//        SyncConfig syncConfig = eventEntity.getSyncConfig();
//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setServerName(syncConfig.getHost());
//        dataSource.setPort(syncConfig.getPort());
//        dataSource.setUser(syncConfig.getUserName());
//        dataSource.setPassword(syncConfig.getPassword());
//        dataSource.setDatabaseName(eventEntity.getDatabaseName());
//        return dataSource;
//    }
//
//    private JdbcTemplate getJdbcTemplate(EventEntity eventEntity){
//        return new JdbcTemplate(buildDataSource(eventEntity));
//    }
//
//    private Map<TableMetaEntity.ColumnMetaData,ChangeData> getChangeDatas(EventEntity eventEntity){
//        Map<TableMetaEntity.ColumnMetaData,ChangeData> changeDatas = new HashMap<>();
//        for(int i = 0; i < eventEntity.getColumns().size(); i++){
//            String before = "";
//            if (eventEntity.getChangeBefore() != null) {
//                before = eventEntity.getChangeBefore().get(i) != null ? eventEntity.getChangeBefore().get(i).toString() : "";
//            }
//            String after = "";
//            if (eventEntity.getChangeAfter() != null) {
//                after = eventEntity.getChangeAfter().get(i) != null ? eventEntity.getChangeAfter().get(i).toString() : "";
//            }
//            ChangeData changeData = new ChangeData(before,after,Objects.equals(before,after));
//            changeDatas.put(eventEntity.getColumns().get(i), changeData);
//        }
//        return changeDatas;
//    }
//
//    private String getKey(EventEntity eventEntity){
//        String key = "";
//        for (int i = 0; i < eventEntity.getKeys().size(); i++){
//            String name = eventEntity.getKeys().get(i).getName();
//            key += name + " = ? and";
//        }
//        key = key.substring(0,key.length()-3);
//        return key;
//    }
//
//    private Object getMysqlFieldType(String type,String value) {
//        String newType = StringUtils.lowerCase(type);
//
//        switch (newType) {
//            case "int":
//            case "tinyint":
//            case "bigint":
//            case "smallint":
//            case "mediumint":
//                return Integer.valueOf(value);
//            case "float":
//            case "double":
//            case "decimal":
//                return Double.valueOf(value);
//            case "timestamp":
//            case "date":
//            case "datetime":
//            case "time":
//                try {
//                    return DateUtils.parseDate(value);
//                } catch (ParseException e) {
//
//                }
//            default:
//                return value;
//        }
//    }
//
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    class ChangeData{
//        private String dataBefore;
//        private String dateAfter;
//        private boolean isChange;
//    }
//}
