package cn.zswltech.preserver.infrastructure.repo.dataaudit;

import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.infrastructure.dataobject.AuditRuleDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T21:26:58+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_302 (BellSoft)"
)
@Component
public class AuditRuleDOMapStructImpl implements AuditRuleDOMapStruct {

    @Override
    public AuditRuleDO toAuditRuleDO(AuditRule auditRule) {
        if ( auditRule == null ) {
            return null;
        }

        AuditRuleDO auditRuleDO = new AuditRuleDO();

        auditRuleDO.setId( auditRule.getId() );
        auditRuleDO.setName( auditRule.getName() );
        auditRuleDO.setGmtCreate( auditRule.getGmtCreate() );
        auditRuleDO.setCreatedBy( auditRule.getCreatedBy() );
        auditRuleDO.setGmtUpdate( auditRule.getGmtUpdate() );
        auditRuleDO.setUpdatedBy( auditRule.getUpdatedBy() );
        auditRuleDO.setRuleDetail( auditRule.getRuleDetail() );

        return auditRuleDO;
    }

    @Override
    public AuditRule toAuditRule(AuditRuleDO auditRuleDO) {
        if ( auditRuleDO == null ) {
            return null;
        }

        AuditRule auditRule = new AuditRule();

        auditRule.setId( auditRuleDO.getId() );
        auditRule.setName( auditRuleDO.getName() );
        auditRule.setGmtCreate( auditRuleDO.getGmtCreate() );
        auditRule.setCreatedBy( auditRuleDO.getCreatedBy() );
        auditRule.setGmtUpdate( auditRuleDO.getGmtUpdate() );
        auditRule.setUpdatedBy( auditRuleDO.getUpdatedBy() );
        auditRule.setRuleDetail( auditRuleDO.getRuleDetail() );

        return auditRule;
    }
}
