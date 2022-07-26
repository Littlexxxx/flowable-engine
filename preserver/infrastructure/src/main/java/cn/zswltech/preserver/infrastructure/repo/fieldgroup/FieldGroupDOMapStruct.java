package cn.zswltech.preserver.infrastructure.repo.fieldgroup;

import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroup;
import cn.zswltech.preserver.infrastructure.dataobject.FieldGroupDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 10:11 上午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FieldGroupDOMapStruct {
    FieldGroupDOMapStruct INSTANCE = Mappers.getMapper(FieldGroupDOMapStruct.class);


    FieldGroupDO toFieldGroupDO(FieldGroup fieldGroup);


    FieldGroup toFieldGroup(FieldGroupDO fieldGroupDO);
}
