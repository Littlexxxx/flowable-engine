package cn.hxh.demo111.core.infrastructure.testjob;

import cn.hxh.demo111.core.domain.testjob.TestJob;
import cn.hxh.demo111.core.domain.testjob.enums.ExecuteTypeEnums;
import cn.hxh.demo111.core.domain.testjob.enums.TaskStatusEnums;
import cn.hxh.demo111.core.infrastructure.Converter;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:51 下午
 * @description:
 **/
@Component
public class TestJobConverter implements Converter<TestJob,TestJobDO> {

    private final TestJobDOMapStruct INSTANCE = TestJobDOMapStruct.INSTANCE;

    @Override
    public TestJob toDomainEntity(TestJobDO testJobDO) {
        TestJob testJob = INSTANCE.toTestJob(testJobDO);
        if(Objects.isNull(testJob)){
            return null;
        }
        if(Objects.nonNull(testJobDO.getTaskStatus())){
            testJob.setTaskStatus(TaskStatusEnums.getByValue(testJobDO.getTaskStatus()).name());
        }
        if(Objects.nonNull(testJobDO.getExecuteType())){
            testJob.setExecuteType(ExecuteTypeEnums.getByValue(testJobDO.getExecuteType()).name());
        }
        return testJob;
    }

    @Override
    public TestJobDO toDataObject(TestJob testJob) {
        TestJobDO testJobDO = INSTANCE.toTestJobDO(testJob);
        if(Objects.isNull(testJobDO)){
            return null;
        }
        if(Objects.nonNull(testJob.getTaskStatus())){
            testJobDO.setTaskStatus(TaskStatusEnums.valueOf(testJob.getTaskStatus()).getValue());
        }
        if(Objects.nonNull(testJob.getExecuteType())){
            testJobDO.setExecuteType(TaskStatusEnums.valueOf(testJob.getTaskStatus()).getValue());
        }
        return testJobDO;
    }

    public List<TestJobDO> toDataObjectList(List<TestJob> testJobList){
        List<TestJobDO> testJobDOList = Lists.newArrayList();
        testJobList.forEach(t -> testJobDOList.add(toDataObject(t)));
        return testJobDOList;
    }
}
