package cn.zswltech.preserver.infrastructure.repo.datasource;

import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.DataSourceDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 5:00 下午
 * @description:
 **/
@Component
public class DataSourceConverter implements Converter<DataSourceModel, DataSourceDO> {
    @Resource
    private DataSourceDOMapStruct dataSourceDOMapStruct;

    @Override
    public DataSourceDO serialize(DataSourceModel dataSourceModel) {
        return dataSourceDOMapStruct.toDataSourceDO(dataSourceModel);
    }

    @Override
    public DataSourceModel deserialize(DataSourceDO dataSourceDO) {
        return dataSourceDOMapStruct.toDataSource(dataSourceDO);
    }
}
