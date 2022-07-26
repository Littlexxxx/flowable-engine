package cn.zswltech.preserver.core.datasource.impl.mysql;

import cn.zswltech.preserver.core.datasource.DataSource;
import cn.zswltech.preserver.core.datasource.constant.ColumnInfo;
import cn.zswltech.preserver.core.datasource.constant.DataTypeEnum;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.core.datasource.utils.ColumnInfoUtil;
import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/13 3:10 下午
 * @description:
 **/
@Slf4j
@Component
public class MysqlDataSourceImpl implements DataSource {
    @Override
    public Map<String, ColumnInfo> parseMetaData(DataSourceModel dataSourceModel) {
        MysqlDataSourceConfig dataSourceConfig = parseConfig(dataSourceModel);
        return getDatasetColumnInfo(dataSourceConfig);
    }

    @Override
    public Boolean testConnection(DataSourceModel dataSourceModel) {
        Connection conn = null;
        try{
            conn = getDataSource(parseConfig(dataSourceModel)).getConnection();
            return conn.isValid(10);
        }catch (SQLException sqlException){
            log.error("连通异常",sqlException);
            return false;
        }finally {
            JdbcUtils.closeConnection(conn);
        }
    }

    @Override
    public String getName() {
        return "MySQL";
    }

    private MysqlDataSourceConfig parseConfig(DataSourceModel dataSourceModel){
        MysqlDataSourceConfig config = JSON.parseObject(dataSourceModel.getConfig(),MysqlDataSourceConfig.class);
        return config;
    }


    private Map<String, ColumnInfo> getDatasetColumnInfo(MysqlDataSourceConfig dataSourceConfig) {
        String databaseName = dataSourceConfig.getDatabaseName();
        String tableName = dataSourceConfig.getTableName();
        List<ColumnInfo> columnInfos = new ArrayList<>();
        JdbcTemplate jdbcTemplate = getJdbcTemplate(dataSourceConfig);
        jdbcTemplate.queryForList(String.format("show full columns from `%s`.`%s`",databaseName,tableName))
                .forEach(originMap ->{
                    ColumnInfo columnInfo = new ColumnInfo();
                    //字段名
                    columnInfo.setName((String) originMap.get("Field"));
                    //获取字段类型
                    columnInfo.setType(ColumnInfoUtil.fromDataType(getMysqlFieldType((String) originMap.get("Type"))));
                    //字段注释
                    columnInfo.setComment((String) originMap.get("Comment"));
                    columnInfos.add(columnInfo);
                });
        return columnInfos.stream().collect(Collectors.toMap(ColumnInfo::getName, Function.identity()));
    }

    public JdbcTemplate getJdbcTemplate(MysqlDataSourceConfig dataSourceConfig) {
        return new JdbcTemplate(getDataSource(dataSourceConfig));
    }

    public JdbcTemplate getJdbcTemplate(MysqlDataSourceConfig dataSourceConfig,String dataBaseName) {
        return new JdbcTemplate(getDataSource(dataSourceConfig,dataBaseName));
    }

    private javax.sql.DataSource getDataSource(MysqlDataSourceConfig dataSourceConfig){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName(dataSourceConfig.getAddress());
        dataSource.setPort(dataSourceConfig.getPort());
        dataSource.setUser(dataSourceConfig.getUserName());
        dataSource.setPassword(dataSourceConfig.getPassword());
        return dataSource;
    }

    private javax.sql.DataSource getDataSource(MysqlDataSourceConfig dataSourceConfig, String dataBaseName){
        MysqlDataSource dataSource = (MysqlDataSource)getDataSource(dataSourceConfig);
        dataSource.setDatabaseName(dataBaseName);
        return dataSource;
    }

    public static String getMysqlFieldType(String type) {
        String newType = StringUtils.lowerCase(type);
        newType = StringUtils.substringBefore(newType, "(");

        switch (newType) {
            case "int":
            case "tinyint":
            case "bigint":
            case "smallint":
            case "mediumint":
                return DataTypeEnum.INT.name();
            case "float":
            case "double":
            case "decimal":
                return DataTypeEnum.DOUBLE.name();
            case "timestamp":
            case "date":
            case "datetime":
            case "time":
                return DataTypeEnum.DATE.name();
            default:
                return DataTypeEnum.STRING.name();
        }
    }



}
