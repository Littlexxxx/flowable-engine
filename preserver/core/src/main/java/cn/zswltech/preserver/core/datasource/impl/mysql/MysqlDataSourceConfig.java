package cn.zswltech.preserver.core.datasource.impl.mysql;

import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/13 4:22 下午
 * @description:
 **/
@Data
public class MysqlDataSourceConfig {
    private String address;
    private int port;
    private String userName;
    private String password;
    private String databaseName;
    private String tableName;
}
