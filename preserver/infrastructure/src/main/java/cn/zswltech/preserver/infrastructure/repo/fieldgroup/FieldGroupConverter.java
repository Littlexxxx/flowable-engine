package cn.zswltech.preserver.infrastructure.repo.fieldgroup;

import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroup;
import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.FieldGroupDO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:29 上午
 * @description:
 **/
@Component
public class FieldGroupConverter implements Converter<FieldGroup, FieldGroupDO> {

    @Resource
    private FieldGroupDOMapStruct fieldGroupDOMapStruct;

    @Override
    public FieldGroupDO serialize(FieldGroup fieldGroup) {
        return fieldGroupDOMapStruct.toFieldGroupDO(fieldGroup);
    }

    @Override
    public FieldGroup deserialize(FieldGroupDO fieldGroupDO) {
        return fieldGroupDOMapStruct.toFieldGroup(fieldGroupDO);
    }
}
