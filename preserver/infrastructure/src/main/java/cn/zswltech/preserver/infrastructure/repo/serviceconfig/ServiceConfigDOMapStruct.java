package cn.zswltech.preserver.infrastructure.repo.serviceconfig;

import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.infrastructure.dataobject.ServiceConfigDO;
import cn.zswltech.preserver.infrastructure.dataobject.SystemFieldDO;
import cn.zswltech.preserver.infrastructure.repo.systemfield.SystemFieldDOMapStruct;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 2:16 下午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServiceConfigDOMapStruct {
    ServiceConfigDOMapStruct INSTANCE = Mappers.getMapper(ServiceConfigDOMapStruct.class);

    ServiceConfigDO toServiceConfigDO(ServiceConfig serviceConfig);

    ServiceConfig toServiceConfig(ServiceConfigDO serviceConfigDO);
}
