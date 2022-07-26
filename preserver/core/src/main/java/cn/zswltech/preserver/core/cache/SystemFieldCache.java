package cn.zswltech.preserver.core.cache;

import cn.zswltech.preserver.core.cache.api.ILocalCache;
import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.field.control.domain.systemfield.SystemFieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 3:18 下午
 * @description:
 **/
@Component
public class SystemFieldCache implements ILocalCache<String, SystemField> {

    @Autowired
    private SystemFieldRepository systemFieldRepository;

    /**
     * 字段code->字段实体
     */
    private final Map<String,SystemField> systemFieldMap = new ConcurrentHashMap<>(128);

    @Override
    public SystemField get(String key) {
        return systemFieldMap.get(key);
    }

    @Override
    public void put(String key, SystemField value) {
        systemFieldMap.put(key,value);
    }

    @Override
    public SystemField remove(String key) {
        SystemField systemField = systemFieldMap.remove(key);
        if(systemField == null){
            return null;
        }
        return systemField;
    }

    @PostConstruct
    public void init(){
        List<SystemField> systemFieldList = systemFieldRepository.queryAll();
        systemFieldMap.putAll(systemFieldList.stream().collect(Collectors.toMap(SystemField::getCode, Function.identity())));
    }
}
