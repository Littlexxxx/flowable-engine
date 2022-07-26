package cn.zswltech.preserver.infrastructure.repo.datasource;

import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.infrastructure.dataobject.DataSourceDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 5:00 下午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DataSourceDOMapStruct {
    DataSourceDOMapStruct INSTANCE = Mappers.getMapper(DataSourceDOMapStruct.class);


    DataSourceDO toDataSourceDO(DataSourceModel dataSourceModel);


    DataSourceModel toDataSource(DataSourceDO dataSourceDO);
}
