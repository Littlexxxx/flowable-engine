package cn.hxh.demo111.core.domain.testjob;

import cn.hxh.demo111.core.infrastructure.testjob.TestJobDO;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:26 下午
 * @description:
 **/
public interface TestJobRepository {
    int batchInsert(List<TestJob> jobLists);

    TestJobDO queryById(int id);
}
