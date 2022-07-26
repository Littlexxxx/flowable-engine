package cn.zswltech.preserver.core.rule.utils;

import cn.zswltech.preserver.core.rule.exception.ParseException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class DataConvertUtils {

    public static Object convertByType(Object ret, String dataType){

        if (StringUtils.isBlank(dataType)){
            return ret;
        }
        switch (dataType) {
            case "string":
                if (ret instanceof String) {
                    return ret;
                } else {
                    return ret.toString();
                }
            case "array":
                if (ret instanceof List) {
                    return ret;
                } else if (ret instanceof Object[]) {
                    return Arrays.asList((Object[]) ret);
                } else if (StringUtils.isNotBlank(ret.toString())) {
                    return Arrays.asList(ret.toString().replaceAll("，", ",").split(","));
                } else {
                    return ret.toString();
                }
            case "double":
                if (ret instanceof Double) {
                    return ret;
                } else {
                    return Double.parseDouble(ret.toString());
                }
            case "int":
                if (ret instanceof Integer) {
                    return ret;
                } else {
                    return Integer.parseInt(ret.toString());
                }
            case "long":
                if (ret instanceof Long) {
                    return ret;
                } else {
                    return Long.parseLong(ret.toString());
                }
            case "boolean":
                if (ret instanceof Boolean) {
                    return ret;
                } else {
                    return Boolean.parseBoolean(ret.toString());
                }
            case "datetime":
                return RuleDateUtils.parseDate(ret);
            case "object":
                return ret;
            default:
                throw new ParseException(" dataType:" + dataType + " not support!");

        }
    }
}