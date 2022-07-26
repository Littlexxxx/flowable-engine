package cn.hxh.demo111.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 5:33 下午
 * @description:
 **/
@Configuration
@MapperScan(
        basePackages = {"cn.hxh.demo111"}
        )
public class LocalMybatisConfig {
}
