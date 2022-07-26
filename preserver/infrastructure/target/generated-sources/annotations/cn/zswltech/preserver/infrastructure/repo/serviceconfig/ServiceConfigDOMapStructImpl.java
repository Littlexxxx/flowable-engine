package cn.zswltech.preserver.infrastructure.repo.serviceconfig;

import cn.zswltech.preserver.infrastructure.dataobject.ServiceConfigDO;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:58+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class ServiceConfigDOMapStructImpl implements ServiceConfigDOMapStruct {

    @Override
    public ServiceConfigDO toServiceConfigDO(ServiceConfig serviceConfig) {
        if ( serviceConfig == null ) {
            return null;
        }

        ServiceConfigDO serviceConfigDO = new ServiceConfigDO();

        serviceConfigDO.setId( serviceConfig.getId() );
        serviceConfigDO.setName( serviceConfig.getName() );
        serviceConfigDO.setServiceCode( serviceConfig.getServiceCode() );
        serviceConfigDO.setIsDelete( serviceConfig.getIsDelete() );
        serviceConfigDO.setDatasourceType( serviceConfig.getDatasourceType() );
        serviceConfigDO.setDatasourceId( serviceConfig.getDatasourceId() );
        serviceConfigDO.setServiceType( serviceConfig.getServiceType() );
        serviceConfigDO.setGmtCreate( serviceConfig.getGmtCreate() );
        serviceConfigDO.setCreatedBy( serviceConfig.getCreatedBy() );
        serviceConfigDO.setGmtUpdate( serviceConfig.getGmtUpdate() );
        serviceConfigDO.setUpdatedBy( serviceConfig.getUpdatedBy() );
        serviceConfigDO.setModel( serviceConfig.getModel() );
        serviceConfigDO.setMappingConfig( serviceConfig.getMappingConfig() );

        return serviceConfigDO;
    }

    @Override
    public ServiceConfig toServiceConfig(ServiceConfigDO serviceConfigDO) {
        if ( serviceConfigDO == null ) {
            return null;
        }

        ServiceConfig serviceConfig = new ServiceConfig();

        serviceConfig.setId( serviceConfigDO.getId() );
        serviceConfig.setName( serviceConfigDO.getName() );
        serviceConfig.setServiceCode( serviceConfigDO.getServiceCode() );
        serviceConfig.setIsDelete( serviceConfigDO.getIsDelete() );
        serviceConfig.setDatasourceType( serviceConfigDO.getDatasourceType() );
        serviceConfig.setDatasourceId( serviceConfigDO.getDatasourceId() );
        serviceConfig.setServiceType( serviceConfigDO.getServiceType() );
        serviceConfig.setGmtCreate( serviceConfigDO.getGmtCreate() );
        serviceConfig.setCreatedBy( serviceConfigDO.getCreatedBy() );
        serviceConfig.setGmtUpdate( serviceConfigDO.getGmtUpdate() );
        serviceConfig.setUpdatedBy( serviceConfigDO.getUpdatedBy() );
        serviceConfig.setModel( serviceConfigDO.getModel() );
        serviceConfig.setMappingConfig( serviceConfigDO.getMappingConfig() );

        return serviceConfig;
    }
}
