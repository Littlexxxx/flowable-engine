package cn.hxh.demo111;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: xinhao.hu
 * @date: 2021/12/25 6:03 下午
 * @description:
 **/
@Configuration
@ImportResource(locations = {"classpath*:spring/*.xml"})
@SpringBootApplication(scanBasePackages = {"cn.hxh","cn.zswltech"})
public class AppMain implements ApplicationContextAware {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AppMain.class);
    }
    private static ApplicationContext context;

    public static ApplicationContext context() {
        return context;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(AppMain.context == null){
            AppMain.context = applicationContext;
        }
    }
}
