package cn.zswltech.preserver.start.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import javax.sql.DataSource;

@Configuration
public class LocalDataSourceConfig {

    @Primary
    @Bean(name = "dataSourceConfig", initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource.druid.primary")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}