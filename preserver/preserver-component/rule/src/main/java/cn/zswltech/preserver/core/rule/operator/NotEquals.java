package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;

public class NotEquals extends AbstractBinaryOperator {

    private Equals equals = new Equals();

    @Override
    protected Boolean apply(Object left, Object right, RuleExecuteContext executeContext) {
        if (null == left || null == right) {
            return false;
        }
        return !equals.apply(left, right, executeContext);
    }

    @Override
    public String getName() {
        return "notEquals";
    }
}