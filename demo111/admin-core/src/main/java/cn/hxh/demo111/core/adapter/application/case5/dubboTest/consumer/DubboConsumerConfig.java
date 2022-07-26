package cn.hxh.demo111.core.adapter.application.case5.dubboTest.consumer;

import cn.hxh.demo111.client.service.LocalTestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xinhao.hu
 * @date: 2022/1/17 10:57 上午
 * @description:
 **/
@Configuration
public class DubboConsumerConfig {
    @DubboReference(version = "${dubbo.test.version}",
            group = "${dubbo.test.group}", retries = 0,
            parameters = {"timeout","${dubbo.test.timeout}"})
    private LocalTestService localTestService;

    @Bean("testDubboService")
    public LocalTestService getTestService(){
        return localTestService;
    }
}
