package cn.hxh.demo111.core.adapter.executor.testjob.exe;

import cn.hxh.demo111.core.domain.testjob.TestJob;
import cn.hxh.demo111.core.domain.testjob.TestJobRepository;
import cn.hxh.demo111.core.infrastructure.testjob.TestJobConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 6:35 下午
 * @description:
 **/
@Component
public class QueryCmdExe {
    @Resource
    private TestJobRepository testJobRepository;

    @Resource
    private TestJobConverter testJobConverter;

    public TestJob execute(int id){
        return testJobConverter.toDomainEntity(testJobRepository.queryById(id));
    }
}
