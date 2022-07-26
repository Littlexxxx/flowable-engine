package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;
import cn.zswltech.preserver.core.rule.exception.RuleRuntimeException;
import cn.zswltech.preserver.core.rule.operator.common.Operator;
import cn.zswltech.preserver.core.rule.variable.Variable;
import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 2:24 下午
 * @description:
 **/
@Data
public abstract class AbstractUnaryOperator implements Operator {
    protected String ruleName;

    protected Variable leftVar;

    @Override
    public EvalResult eval(RuleExecuteContext ruleExecuteContext) {
        if (leftVar == null ){
            throw new RuleRuntimeException("args can't not be null");
        }
        Object left = leftVar.eval(ruleExecuteContext);

        if(left == EvalResult.Unknown){
            return EvalResult.Unknown;
        }
        EvalResult evalResult = EvalResult.valueOf(apply(left,ruleExecuteContext));
        return evalResult;
    }

    protected abstract Boolean apply(Object left, RuleExecuteContext ruleExecuteContext);


}
