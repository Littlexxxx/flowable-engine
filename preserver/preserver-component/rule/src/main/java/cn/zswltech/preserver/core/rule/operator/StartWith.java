package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import org.apache.commons.lang3.StringUtils;

public class StartWith extends AbstractBinaryOperator {
    @Override
    protected Boolean apply(Object left, Object right, RuleExecuteContext executeContext) {
        if (null == left || null == right) {
            return false;
        }
        return StringUtils.startsWith(left.toString(), right.toString());
    }

    @Override
    public String getName() {
        return "startWith";
    }
}