package cn.hxh.demo111.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xinhao.hu
 * @date: 2022/1/14 3:53 下午
 * @description:
 **/
@Configuration
@EnableDubbo(scanBasePackages = "cn.hxh.demo111")
public class RpcServiceConfig {
}
