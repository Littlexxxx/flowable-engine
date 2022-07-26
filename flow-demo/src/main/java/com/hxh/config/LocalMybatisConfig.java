package com.hxh.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class LocalMybatisConfig {


        @Autowired
        @Qualifier("dataSource")
        private DataSource dataSource;

        private static final String mybatisConfig = "mybatis/mybatis-config.xml";

        /**
         * mapper扫描路径
         */
        private static final String mapperPath = "classpath*:flow/mapper/*Mapper.xml";


        @Primary
        @Bean
        public SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
                SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
                factory.setDataSource(dataSource);
                factory.setConfigLocation(new ClassPathResource(mybatisConfig));

                //添加XML目录
                ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resolver.getResources(mapperPath);
                factory.setMapperLocations(resources);
                return factory;
        }

        @Bean
        public SqlSessionFactory sqlSessionFactory() {
                try {
                        return sqlSessionFactoryBean().getObject();
                } catch (Exception e) {
                        throw  new RuntimeException(e);
                }
        }


        @Bean
        public SqlSessionTemplate sqlSessionTemplate(){
                return new SqlSessionTemplate(sqlSessionFactory());
        }


        @Bean
        @Primary
        public PlatformTransactionManager txManager() {
                return new DataSourceTransactionManager(dataSource);
        }

}