package cn.hxh.demo111.core.adapter.application.case5.dubboTest.provider;

import cn.hxh.demo111.client.service.LocalTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author: xinhao.hu
 * @date: 2022/1/14 3:39 下午
 * @description:
 **/
@Primary
@Service
public class LocalTestServiceImpl implements LocalTestService {
    private Logger logger = LoggerFactory.getLogger(LocalTestServiceImpl.class);

    @Override
    public String HelloWorld() {
        logger.info("Hello world");
        return "Hello World";
    }
}
