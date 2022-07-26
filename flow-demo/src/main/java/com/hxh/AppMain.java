package com.hxh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 程序入口
 *
 * @date 2022-03-25
 * @author wangenhao
 */
@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class, KafkaAutoConfiguration.class},
        scanBasePackages = {"com.hxh","cn.zswltech"})
@EnableScheduling
@RestController
public class AppMain {
    public static void main(String[] args) {
        SpringApplication.run(AppMain.class, args);
    }
    @RequestMapping({"ok", "ok.htm", "ok.html"})
    String version() {
        return "ok";
    }
}

