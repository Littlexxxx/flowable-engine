package cn.zswltech.preserver.infrastructure.repo.systemfield;

import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.SystemFieldDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:34 上午
 * @description: 
 **/
@Component
public class SystemFieldConverter implements Converter<SystemField, SystemFieldDO> {
    @Resource
    private SystemFieldDOMapStruct systemFieldDOMapStruct;

    @Override
    public SystemFieldDO serialize(SystemField systemField) {
        return systemFieldDOMapStruct.toSystemFieldDO(systemField);
    }

    @Override
    public SystemField deserialize(SystemFieldDO systemFieldDO) {
        return systemFieldDOMapStruct.toSystemField(systemFieldDO);
    }
}
