package cn.hxh.demo111.core.infrastructure.testjob;

import cn.hxh.demo111.core.domain.testjob.TestJob;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:12 下午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TestJobDOMapStruct {
    TestJobDOMapStruct INSTANCE = Mappers.getMapper(TestJobDOMapStruct.class);

    @Mappings({
            @Mapping(target = "taskStatus",ignore = true),
            @Mapping(target = "executeType",ignore = true)
    })
    TestJob toTestJob(TestJobDO testJobDO);

    @Mappings({
            @Mapping(target = "taskStatus",ignore = true),
            @Mapping(target = "executeType",ignore = true)
    })
    TestJobDO toTestJobDO(TestJob testJob);

}
