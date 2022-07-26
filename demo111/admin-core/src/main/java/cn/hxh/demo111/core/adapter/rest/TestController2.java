package cn.hxh.demo111.core.adapter.rest;

import cn.hxh.demo111.client.service.LocalTestService;
import cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory.AddClassToSpring;
import cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory.Extension;
import cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory.ExtensionClass1;
import cn.hxh.demo111.core.adapter.client.cmd.AcceptCmd;
import cn.hxh.demo111.core.adapter.service.TestJobService;
import cn.hxh.demo111.core.domain.testjob.TestJob;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author: xinhao.hu
 * @date: 2021/12/25 5:57 下午
 * @description:
 **/
@RestController
@RequestMapping("")
public class TestController2 {

    @Resource
    private AddClassToSpring addClassToSpring;

    @Resource(name = "testDubboService")
    private LocalTestService dubboLocalTestService;

    @Resource
    private TestJobService testJobService;

    @GetMapping("hello")
    public String hello(){
        ApplicationContext applicationContext = addClassToSpring.add();
        ExtensionClass1 extensionClass1 = (ExtensionClass1) applicationContext.getBean(Extension.class);
        extensionClass1.say();
        return null;
    }

    @GetMapping("dubboHello")
    public String dubboHello(){
        return dubboLocalTestService.HelloWorld();
    }

    @GetMapping("queryTestJob")
    public TestJob getById(int id){
        return testJobService.getById(id);
    }

    @PostMapping("testFileAccept")
    public String testFile(@ModelAttribute AcceptCmd cmd) throws IOException {
        if(cmd.getFile()==null||cmd.getId()==null){
            return "fail";
        }
        return "accept success";
    }
}
