package cn.zswltech.preserver.core.rule.eval;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.rule.Rule;
import cn.zswltech.preserver.core.rule.rule.RuleResult;
import org.springframework.stereotype.Component;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 3:20 下午
 * @description:
 **/
@Component
public class RuleExecuteEngine {

    public RuleResult execute(Rule rule, RuleExecuteContext context){
        RuleResult ruleResult = new RuleResult();
        ruleResult.setOriginData(context.getOriginDatas());
        try{
            EvalResult res = rule.execute(context);
            ruleResult.setEvalResult(res);
        }catch(Exception e){
            ruleResult.setException(e);
        }

        return ruleResult;
    }
}
