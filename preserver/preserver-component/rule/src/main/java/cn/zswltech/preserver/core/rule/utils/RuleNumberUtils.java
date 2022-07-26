package cn.zswltech.preserver.core.rule.utils;

import org.apache.commons.lang3.math.NumberUtils;

public class RuleNumberUtils {


    private static boolean isNumeric(Object value) {
        return null != value && (value instanceof Number || NumberUtils.isCreatable(value.toString()));
    }

    public static double parseDouble(Object value) {
        if (!isNumeric(value)) {
            return Double.NaN;
        }
        return Double.parseDouble(value.toString());
    }

    public static boolean isInteger(String x) {
        try {
            double d = Double.parseDouble(x);
            return Math.floor(d) == d;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}