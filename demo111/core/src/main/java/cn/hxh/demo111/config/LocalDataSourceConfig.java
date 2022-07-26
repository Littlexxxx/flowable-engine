package cn.hxh.demo111.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 5:33 下午
 * @description:
 **/
@Configuration
public class LocalDataSourceConfig {

    @Primary
    @Bean(name = "dataSourceConfig", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.primary")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}
