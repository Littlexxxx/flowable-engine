package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.exception.RuleRuntimeException;
import cn.zswltech.preserver.core.rule.operator.common.Operator;
import cn.zswltech.preserver.core.rule.variable.Variable;
import cn.zswltech.preserver.core.rule.variable.consts.Const;
import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 11:47 上午
 * @description:
 **/
@Data
public abstract class AbstractBinaryOperator implements Operator {
    protected String ruleName;

    protected Variable leftVar;
    protected Variable rightVar;

    @Override
    public EvalResult eval(RuleExecuteContext ruleExecuteContext) {
        if (leftVar == null || rightVar == null){
            throw new RuleRuntimeException("args can't not be null");
        }
        Object left = leftVar.eval(ruleExecuteContext);
        Object right = rightVar.eval(ruleExecuteContext);

        if(left == EvalResult.Unknown || right == EvalResult.Unknown){
            return EvalResult.Unknown;
        }
        EvalResult evalResult = EvalResult.valueOf(apply(left,right,ruleExecuteContext));
        // save detail
        if (evalResult == EvalResult.True && null != leftVar.getDetail(left)) {
            ruleExecuteContext.saveDetail(leftVar.getDetail(left),ruleName);
            // 右变量为常量是不写详情
            if (!(rightVar instanceof Const) && null != leftVar.getDetail(right)) {
                ruleExecuteContext.saveDetail(leftVar.getDetail(right),ruleName);
            }
        }
        return evalResult;
    }

    protected abstract Boolean apply(Object left, Object right, RuleExecuteContext ruleExecuteContext);
}
