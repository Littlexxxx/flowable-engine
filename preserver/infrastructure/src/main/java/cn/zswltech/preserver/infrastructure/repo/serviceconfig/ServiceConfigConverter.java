package cn.zswltech.preserver.infrastructure.repo.serviceconfig;

import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.ServiceConfigDO;
import cn.zswltech.preserver.service.config.domain.MappingRelation;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 2:16 下午
 * @description:
 **/
@Component
public class ServiceConfigConverter implements Converter<ServiceConfig, ServiceConfigDO> {

    @Resource
    private ServiceConfigDOMapStruct serviceConfigDOMapStruct;

    @Override
    public ServiceConfigDO serialize(ServiceConfig serviceConfig) {
        return serviceConfigDOMapStruct.toServiceConfigDO(serviceConfig);
    }

    @Override
    public ServiceConfig deserialize(ServiceConfigDO serviceConfigDO) {
        ServiceConfig serviceConfig = serviceConfigDOMapStruct.toServiceConfig(serviceConfigDO);
        List<MappingRelation> relations = JSON.parseObject(serviceConfig.getMappingConfig(), new TypeReference<List<MappingRelation>>() {});
        serviceConfig.setMappingConfigModel(relations.stream().collect(Collectors.toMap(MappingRelation::getOriginName, Function.identity())));
        return serviceConfig;
    }
}
