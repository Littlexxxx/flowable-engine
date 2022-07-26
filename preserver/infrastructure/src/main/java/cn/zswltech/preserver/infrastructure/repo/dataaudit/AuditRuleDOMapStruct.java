package cn.zswltech.preserver.infrastructure.repo.dataaudit;

import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.field.control.domain.fieldgroup.FieldGroup;
import cn.zswltech.preserver.infrastructure.dataobject.AuditRuleDO;
import cn.zswltech.preserver.infrastructure.dataobject.FieldGroupDO;
import cn.zswltech.preserver.infrastructure.repo.fieldgroup.FieldGroupDOMapStruct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 10:07 上午
 * @description:
 **/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuditRuleDOMapStruct {
    AuditRuleDOMapStruct INSTANCE = Mappers.getMapper(AuditRuleDOMapStruct.class);


    AuditRuleDO toAuditRuleDO(AuditRule auditRule);


    AuditRule toAuditRule(AuditRuleDO auditRuleDO);
}
