package cn.hxh.demo111.core.infrastructure.testjob;

import cn.hxh.demo111.core.domain.testjob.TestJob;
import cn.hxh.demo111.core.domain.testjob.TestJobRepository;
import cn.hxh.demo111.core.infrastructure.mapper.TestJobDOMapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 5:09 下午
 * @description:
 **/
@Component
public class TestJobRepositoryImpl implements TestJobRepository {

    @Resource
    private TestJobDOMapper testJobDOMapper;

    @Resource
    private TestJobConverter testJobConverter;

    @Override
    public int batchInsert(List<TestJob> jobLists) {
        return testJobDOMapper.insertList(testJobConverter.toDataObjectList(jobLists));
    }

    @Override
    public TestJobDO queryById(int id) {
        Example example = new Example(TestJobDO.class);
        example.createCriteria()
                .andEqualTo("id",id);
        return testJobDOMapper.selectOneByExample(example);
    }
}
