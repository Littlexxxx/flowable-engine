package cn.zswltech.preserver.infrastructure.repo.datasource;

import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.infrastructure.dataobject.DataSourceDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:59+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class DataSourceDOMapStructImpl implements DataSourceDOMapStruct {

    @Override
    public DataSourceDO toDataSourceDO(DataSourceModel dataSourceModel) {
        if ( dataSourceModel == null ) {
            return null;
        }

        DataSourceDO dataSourceDO = new DataSourceDO();

        dataSourceDO.setId( dataSourceModel.getId() );
        dataSourceDO.setName( dataSourceModel.getName() );
        dataSourceDO.setDesc( dataSourceModel.getDesc() );
        dataSourceDO.setType( dataSourceModel.getType() );
        dataSourceDO.setOrg( dataSourceModel.getOrg() );
        dataSourceDO.setModel( dataSourceModel.getModel() );
        dataSourceDO.setGmtCreate( dataSourceModel.getGmtCreate() );
        dataSourceDO.setCreatedBy( dataSourceModel.getCreatedBy() );
        dataSourceDO.setGmtUpdate( dataSourceModel.getGmtUpdate() );
        dataSourceDO.setUpdatedBy( dataSourceModel.getUpdatedBy() );
        dataSourceDO.setConfig( dataSourceModel.getConfig() );
        dataSourceDO.setMetaData( dataSourceModel.getMetaData() );

        return dataSourceDO;
    }

    @Override
    public DataSourceModel toDataSource(DataSourceDO dataSourceDO) {
        if ( dataSourceDO == null ) {
            return null;
        }

        DataSourceModel dataSourceModel = new DataSourceModel();

        dataSourceModel.setId( dataSourceDO.getId() );
        dataSourceModel.setName( dataSourceDO.getName() );
        dataSourceModel.setDesc( dataSourceDO.getDesc() );
        dataSourceModel.setType( dataSourceDO.getType() );
        dataSourceModel.setOrg( dataSourceDO.getOrg() );
        dataSourceModel.setModel( dataSourceDO.getModel() );
        dataSourceModel.setGmtCreate( dataSourceDO.getGmtCreate() );
        dataSourceModel.setCreatedBy( dataSourceDO.getCreatedBy() );
        dataSourceModel.setGmtUpdate( dataSourceDO.getGmtUpdate() );
        dataSourceModel.setUpdatedBy( dataSourceDO.getUpdatedBy() );
        dataSourceModel.setConfig( dataSourceDO.getConfig() );
        dataSourceModel.setMetaData( dataSourceDO.getMetaData() );

        return dataSourceModel;
    }
}
