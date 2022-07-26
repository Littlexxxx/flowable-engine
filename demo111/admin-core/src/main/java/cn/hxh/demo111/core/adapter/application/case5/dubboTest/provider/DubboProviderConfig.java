package cn.hxh.demo111.core.adapter.application.case5.dubboTest.provider;

import cn.hxh.demo111.client.service.LocalTestService;
import org.apache.dubbo.config.spring.ServiceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xinhao.hu
 * @date: 2022/1/14 4:00 下午
 * @description:
 **/
@Configuration
public class DubboProviderConfig {
    // -- bean define
    @Bean
    public ServiceBean<LocalTestService> testServiceBean(@Autowired LocalTestService localTestService){
        ServiceBean<LocalTestService> serviceBean = new ServiceBean();
        serviceBean.setInterface(LocalTestService.class);
        serviceBean.setRef(localTestService);
        return serviceBean;
    }
}
