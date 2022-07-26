package cn.zswltech.preserver.core.rule.operator;


import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import org.apache.commons.lang3.StringUtils;

public class NotEmpty extends AbstractUnaryOperator {
    @Override
    protected Boolean apply(Object left, RuleExecuteContext executeContext) {
        if (null == left) {
            return false;
        }
        return StringUtils.isNotBlank(left.toString());
    }

    @Override
    public String getName() {
        return "notEmpty";
    }
}
