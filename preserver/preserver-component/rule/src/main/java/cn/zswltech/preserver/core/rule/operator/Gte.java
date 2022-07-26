package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.utils.RuleDateUtils;
import cn.zswltech.preserver.core.rule.utils.RuleNumberUtils;

import java.util.Date;

public class Gte extends AbstractBinaryOperator {
    @Override
    protected Boolean apply(Object left, Object right, RuleExecuteContext executeContext) {
        if (null == left || null == right) {
            return false;
        }
        if (left instanceof Date) {
            Date rightDate = RuleDateUtils.parseDate(right);
            if (null == rightDate) {
                return false;
            }
            return ((Date) left).compareTo(rightDate) >= 0;
        }
        double leftValue = RuleNumberUtils.parseDouble(left);
        if (Double.isNaN(leftValue)) {
            return false;
        }
        double rightValue = RuleNumberUtils.parseDouble(right);
        if (Double.isNaN(rightValue)) {
            return false;
        }
        return leftValue >= rightValue;
    }

    @Override
    public String getName() {
        return "gte";
    }
}