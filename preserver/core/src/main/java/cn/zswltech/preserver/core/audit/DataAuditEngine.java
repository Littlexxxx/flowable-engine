package cn.zswltech.preserver.core.audit;

import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.RuleExecuteEngine;
import cn.zswltech.preserver.core.rule.rule.Rule;
import cn.zswltech.preserver.core.rule.rule.RuleResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/24 5:41 下午
 * @description: 规则执行引擎
 **/
@Component
public class DataAuditEngine {

    @Autowired
    private RuleExecuteEngine ruleExecuteEngine;

    public AuditResponse audit(AuditRequest request){
        AuditResponse auditResponse = new AuditResponse();
        List<Map<String,Object>> datas = request.getAuditData();
        Rule rule = request.getRule();
        RuleEvalContext ruleEvalContext = new RuleEvalContext();
        datas.forEach(t -> {
            RuleResult ruleResult = new RuleResult();
            ruleEvalContext.refresh(t,ruleResult);
            ruleResult = ruleExecuteEngine.execute(rule,ruleEvalContext);

            if(ruleResult.getEvalResult().equals(EvalResult.True)){
                auditResponse.getAcceptData().add(ruleResult);
            }else if(ruleResult.getEvalResult().equals(EvalResult.False)){
                auditResponse.getRejectData().add(ruleResult);
            }

        });
        return auditResponse;
    }
}
