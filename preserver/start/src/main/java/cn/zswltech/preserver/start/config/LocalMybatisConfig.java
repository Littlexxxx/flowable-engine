package cn.zswltech.preserver.start.config;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan(
        basePackages = {"cn.zswltech.preserver.infrastructure.mapper"}
        )
public class LocalMybatisConfig {
}