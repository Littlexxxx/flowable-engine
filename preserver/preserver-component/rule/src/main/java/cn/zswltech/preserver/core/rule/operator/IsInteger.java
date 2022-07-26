package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.utils.RuleNumberUtils;

public class IsInteger extends AbstractUnaryOperator {
    @Override
    protected Boolean apply(Object left, RuleExecuteContext executeContext) {
        if (null == left) {
            return false;
        }
        if (left instanceof Integer) {
            return true;
        }
        return RuleNumberUtils.isInteger(left.toString());
    }

    @Override
    public String getName() {
        return "isInteger";
    }
}
