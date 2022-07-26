package com.hxh.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

import static cn.zswltech.flow.core.config.ProjectConstant.MAPPER_PACKAGE;
import static cn.zswltech.flow.core.config.ProjectConstant.MODEL_PACKAGE;
import static org.springframework.transaction.TransactionDefinition.ISOLATION_DEFAULT;

/**
 * flow mysql连接配置
 */
//@Configuration
public class DataSourceConfig {

    @ConfigurationProperties(prefix = "flow.jdbc")
    @Bean("flowMysqlConfig")
    public MysqlConfig mysqlConfig() {
        MysqlConfig mysqlConfig = new MysqlConfig();
        return mysqlConfig;
    }

    @Bean(name = "flowDataSource")
    public DataSource mybatisDataSource(@Qualifier("flowMysqlConfig") MysqlConfig mysqlConfig) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(mysqlConfig.getDriverClassName());
        dataSource.setUrl(mysqlConfig.getUrl());
        dataSource.setUsername(mysqlConfig.getName());
        dataSource.setPassword(mysqlConfig.getPassword());
        dataSource.setMaxActive(mysqlConfig.getMaxConnections());
        dataSource.setMaxWait(5000);
        dataSource.setInitialSize(3);
        return dataSource;
    }

    @Bean(name = "flowSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("flowDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(MODEL_PACKAGE);

        //配置分页插件，详情请查阅官方文档
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("pageSizeZero", "true");//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", "true");//页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", "true");//支持通过 Mapper 接口参数来传递分页参数
        pageHelper.setProperties(properties);

        //添加插件
        factory.setPlugins(new Interceptor[]{pageHelper, new PrintSqlInterceptor()});

        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources("classpath:flow/mapper/*.xml"));
        return factory.getObject();
    }

    @Bean(name = "flowTransactionManager")
    public DataSourceTransactionManager mybatisTransactionManager(@Qualifier("flowDataSource") DataSource mybatisDataSource) {
        return new DataSourceTransactionManager(mybatisDataSource);
    }

    @Bean(name = "flowTransactionTemplate")
    public TransactionTemplate transactionTemplate(@Qualifier("flowTransactionManager") DataSourceTransactionManager mybatisTransactionManager) {
        TransactionTemplate transactionTemplate = new TransactionTemplate();
        transactionTemplate.setIsolationLevel(ISOLATION_DEFAULT);
        transactionTemplate.setTimeout(10);
        transactionTemplate.setTransactionManager(mybatisTransactionManager);
        return transactionTemplate;
    }


}
