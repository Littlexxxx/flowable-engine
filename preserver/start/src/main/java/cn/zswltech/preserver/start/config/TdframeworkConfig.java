package cn.zswltech.preserver.start.config;

import cn.tongdun.tdframework.core.boot.Bootstrap;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/19 5:25 下午
 * @description:
 **/
@Configuration
public class TdframeworkConfig {

    @Bean(initMethod = "init")
    public Bootstrap bootstrap(){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setPackages(Lists.newArrayList("cn.zswltech"));
        return bootstrap;
    }
}
