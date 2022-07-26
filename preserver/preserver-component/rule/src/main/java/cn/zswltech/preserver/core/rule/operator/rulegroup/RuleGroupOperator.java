package cn.zswltech.preserver.core.rule.operator.rulegroup;

import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;
import cn.zswltech.preserver.core.rule.operator.common.Operator;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 10:07 上午
 * @description:
 **/
public abstract class RuleGroupOperator implements Operator {
    protected List<EvalResult> operandResult;

    public void setOperandResult(List<EvalResult> result){
        operandResult = result;
    }
}
