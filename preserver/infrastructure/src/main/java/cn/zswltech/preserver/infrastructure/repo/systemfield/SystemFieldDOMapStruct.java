package cn.zswltech.preserver.infrastructure.repo.systemfield;

import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.infrastructure.dataobject.SystemFieldDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:11 上午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SystemFieldDOMapStruct {
    SystemFieldDOMapStruct INSTANCE = Mappers.getMapper(SystemFieldDOMapStruct.class);


    SystemFieldDO toSystemFieldDO(SystemField systemField);


    SystemField toSystemField(SystemFieldDO systemField);
}
