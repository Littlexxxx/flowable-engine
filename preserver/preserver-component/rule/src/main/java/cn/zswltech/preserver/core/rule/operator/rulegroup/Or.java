package cn.zswltech.preserver.core.rule.operator.rulegroup;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 10:11 上午
 * @description:
 **/
public class Or extends RuleGroupOperator{
    @Override
    public String getName() {
        return "or";
    }

    @Override
    public EvalResult eval(RuleExecuteContext ruleExecuteContext) {
        for (EvalResult eval : operandResult) {
            if (eval == EvalResult.Unknown) {
                return EvalResult.Unknown;
            } else if (eval == EvalResult.Exception) {
                return EvalResult.Exception;
            } else if (eval == EvalResult.True) {
                return EvalResult.True;
            }
        }
        return EvalResult.False;
    }
}
