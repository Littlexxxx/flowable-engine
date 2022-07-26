package cn.zswltech.preserver.core.rule.operator;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.utils.RuleDateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

public class Equals extends AbstractBinaryOperator {

    @Override
    protected Boolean apply(Object left, Object right, RuleExecuteContext executeContext) {
        if (null == left || null == right) {
            return false;
        }
        if ((left instanceof Boolean) && (right instanceof String)) {
            Boolean leftBool = (Boolean) left;
            String rightString = (String) right;
            if (leftBool && StringUtils.equalsIgnoreCase(rightString, "1")) {
                return true;
            }
        }

        if (left instanceof Comparable && right instanceof Comparable
                && (left.getClass().isAssignableFrom(right.getClass()))){
            if( ((Comparable)left).compareTo((Comparable)right) ==0) {
                return true;
            }
        }

        if (left instanceof Double && right instanceof String){
            return left.equals(Double.valueOf(right.toString()));
        }

        if (left instanceof Date) {
            Date rightDate = RuleDateUtils.parseDate(right);
            if (null == rightDate) {
                return false;
            }
            return left.equals(rightDate);
        }

        if (right instanceof String) {
            return StringUtils.equals(left.toString(), right.toString());
        }
        return left.equals(right);
    }

    @Override
    public String getName() {
        return "equals";
    }
}