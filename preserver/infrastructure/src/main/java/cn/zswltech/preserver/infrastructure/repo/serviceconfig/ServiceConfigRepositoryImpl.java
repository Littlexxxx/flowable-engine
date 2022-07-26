package cn.zswltech.preserver.infrastructure.repo.serviceconfig;

import cn.zswltech.preserver.infrastructure.dataobject.ServiceConfigDO;
import cn.zswltech.preserver.infrastructure.mapper.ServiceConfigMapper;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import cn.zswltech.preserver.service.config.domain.ServiceConfigRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 2:17 下午
 * @description:
 **/
@Repository
public class ServiceConfigRepositoryImpl implements ServiceConfigRepository {

    @Resource
    private ServiceConfigMapper serviceConfigMapper;

    @Resource
    private ServiceConfigConverter serviceConfigConverter;

    @Override
    public void update(ServiceConfig serviceConfig) {

    }

    @Override
    public void delete(ServiceConfig serviceConfig) {

    }

    @Override
    public void create(ServiceConfig serviceConfig) {

    }

    @Override
    public ServiceConfig getFieldGroup(int id) {
        return null;
    }

    @Override
    public List<ServiceConfig> searchFieldGroup() {
        return null;
    }

    @Override
    public List<ServiceConfig> queryAll() {
        List<ServiceConfigDO> serviceConfigDOList = serviceConfigMapper.selectAll();;
        return serviceConfigDOList.stream().map(serviceConfigConverter::deserialize).collect(Collectors.toList());
    }
}
