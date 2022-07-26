package cn.zswltech.preserver.core.rule.operator;


import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.utils.RuleNumberUtils;

public class isTrue extends AbstractUnaryOperator{

    @Override
    protected Boolean apply(Object left, RuleExecuteContext executeContext) {
        if (null == left) {
            return false;
        }
        return (Boolean) left;
    }

    @Override
    public String getName() {
        return "isTrue";
    }
}
