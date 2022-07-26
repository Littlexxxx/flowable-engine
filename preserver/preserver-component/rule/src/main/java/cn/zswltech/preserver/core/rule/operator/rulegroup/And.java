package cn.zswltech.preserver.core.rule.operator.rulegroup;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 10:09 上午
 * @description:
 **/
public class And extends RuleGroupOperator{
    @Override
    public String getName() {
        return "and";
    }

    @Override
    public EvalResult eval(RuleExecuteContext ruleExecuteContext) {
        for (EvalResult eval : operandResult) {
            if (eval != EvalResult.True) {
                return eval;
            }
        }
        return EvalResult.True;
    }
}
