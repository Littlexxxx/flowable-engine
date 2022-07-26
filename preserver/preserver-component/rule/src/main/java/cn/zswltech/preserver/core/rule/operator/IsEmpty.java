package cn.zswltech.preserver.core.rule.operator;


import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import org.apache.commons.lang3.StringUtils;

public class IsEmpty extends AbstractUnaryOperator {
    @Override
    protected Boolean apply(Object left, RuleExecuteContext executeContext) {
        return null == left || StringUtils.isBlank(left.toString());
    }

    @Override
    public String getName() {
        return "isEmpty";
    }
}
