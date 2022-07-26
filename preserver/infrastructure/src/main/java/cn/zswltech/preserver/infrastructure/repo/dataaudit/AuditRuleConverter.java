package cn.zswltech.preserver.infrastructure.repo.dataaudit;

import cn.zswltech.preserver.core.rule.parser.RuleParser;
import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.infrastructure.common.Converter;
import cn.zswltech.preserver.infrastructure.dataobject.AuditRuleDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 10:08 上午
 * @description:
 **/
@Component
public class AuditRuleConverter implements Converter<AuditRule, AuditRuleDO> {

    @Resource
    private AuditRuleDOMapStruct auditRuleDOMapStruct;

    @Autowired
    private RuleParser ruleParser;

    @Override
    public AuditRuleDO serialize(AuditRule auditRule) {
        return auditRuleDOMapStruct.toAuditRuleDO(auditRule);
    }

    @Override
    public AuditRule deserialize(AuditRuleDO auditRuleDO) {
        AuditRule auditRule = auditRuleDOMapStruct.toAuditRule(auditRuleDO);
        auditRule.setRule(ruleParser.ruleParser(auditRule.getRuleDetail()));
        return auditRule;
    }
}
