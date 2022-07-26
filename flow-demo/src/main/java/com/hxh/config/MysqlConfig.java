package com.hxh.config;

import lombok.Data;

/**
 * 数据库配置
 *
 * @author wangchuanhao
 * @date 2022/5/9 11:47 PM
 */
@Data
public class MysqlConfig {

    private String driverClassName;

    private String url;

    private String name;

    private String password;

    private Integer maxConnections;

}
