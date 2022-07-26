package cn.zswltech.preserver.infrastructure.repo.dataaudit;

import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.data.audit.domain.AuditRuleRepository;
import cn.zswltech.preserver.infrastructure.dataobject.AuditRuleDO;
import cn.zswltech.preserver.infrastructure.mapper.AuditRuleMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 10:09 上午
 * @description:
 **/
@Repository
public class AuditRuleRepositoryImpl implements AuditRuleRepository {

    @Resource
    private AuditRuleMapper auditRuleMapper;

    @Resource
    private AuditRuleConverter auditRuleConverter;

    @Override
    public List<AuditRule> queryAll() {
        List<AuditRuleDO> auditRuleDOList = auditRuleMapper.selectAll();
        return auditRuleDOList.stream()
                .map(auditRuleConverter::deserialize)
                .collect(Collectors.toList());
    }
}
