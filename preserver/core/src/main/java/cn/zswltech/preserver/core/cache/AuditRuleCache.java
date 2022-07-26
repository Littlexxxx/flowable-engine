package cn.zswltech.preserver.core.cache;

import cn.zswltech.preserver.core.cache.api.ILocalCache;
import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.data.audit.domain.AuditRuleRepository;
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
public class AuditRuleCache implements ILocalCache<Integer, AuditRule> {
    private Map<Integer,AuditRule> auditRuleCache = new HashMap();

    @Autowired
    private AuditRuleRepository auditRuleRepository;

    @Override
    public AuditRule get(Integer key) {
        return auditRuleCache.get(key);
    }

    @Override
    public void put(Integer key, AuditRule value) {
        auditRuleCache.put(key,value);
    }

    @Override
    public AuditRule remove(Integer key) {
        return auditRuleCache.remove(key);
    }

    @PostConstruct
    public void init(){
        List<AuditRule> auditRuleList = auditRuleRepository.queryAll();
        auditRuleCache.putAll(auditRuleList.stream().collect(Collectors.toMap(AuditRule::getId, Function.identity())));
    }
}
