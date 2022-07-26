package cn.hxh.demo111.core.adapter.executor.testjob;

import cn.hxh.demo111.core.adapter.executor.testjob.exe.QueryCmdExe;
import cn.hxh.demo111.core.adapter.service.TestJobService;
import cn.hxh.demo111.core.domain.testjob.TestJob;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 6:34 下午
 * @description:
 **/
@Service
public class TestJobServiceImpl implements TestJobService {

    @Resource
    private QueryCmdExe queryCmdExe;

    @Override
    public TestJob getById(int id){
        return queryCmdExe.execute(id);
    }
}
