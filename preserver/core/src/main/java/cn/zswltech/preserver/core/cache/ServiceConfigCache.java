package cn.zswltech.preserver.core.cache;

import cn.zswltech.preserver.core.cache.api.ILocalCache;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import cn.zswltech.preserver.service.config.domain.ServiceConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 3:25 下午
 * @description:
 **/
@Component
public class ServiceConfigCache implements ILocalCache<Integer, ServiceConfig> {

    private Map<Integer, ServiceConfig> serviceConfigCache = new HashMap();

    @Autowired
    private ServiceConfigRepository serviceConfigRepository;

    @Override
    public ServiceConfig get(Integer key) {
        return serviceConfigCache.get(key);
    }

    @Override
    public void put(Integer key, ServiceConfig value) {
        serviceConfigCache.put(key,value);
    }

    @Override
    public ServiceConfig remove(Integer key) {
        return serviceConfigCache.remove(key);
    }

    @PostConstruct
    public void init(){
        List<ServiceConfig> serviceConfigList = serviceConfigRepository.queryAll();
        serviceConfigCache.putAll(serviceConfigList.stream().collect(Collectors.toMap(ServiceConfig::getId, Function.identity())));
    }

}
