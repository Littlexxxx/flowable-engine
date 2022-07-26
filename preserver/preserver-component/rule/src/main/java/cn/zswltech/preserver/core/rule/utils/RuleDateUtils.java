package cn.zswltech.preserver.core.rule.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

public class RuleDateUtils {

    private static final FastDateFormat dateFormat = createDateFormat("yyyy-MM-dd");
    private static final FastDateFormat datetimeFormat = createDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final FastDateFormat yyyyMMddHHmmssSSS = createDateFormat("yyyyMMddHHmmssSSS");
    private static final FastDateFormat yyyyMMdd = createDateFormat("yyyyMMdd");

    /**
     * 返回自定义时间格式化工具
     *
     * @param pattern
     * @return
     */
    public static FastDateFormat createDateFormat(String pattern) {
        return FastDateFormat.getInstance(pattern);
    }

    public static Date parseDate(Object value) {
        if (null == value) {
            return null;
        }
        if (value instanceof Date) {
            return (Date) value;
        } else if (value instanceof Long) {
            return new Date((long) value);
        } else if (StringUtils.isNumeric(value.toString())) {
            return new Date(Long.parseLong(value.toString()));
        } else {
            try {
                return parseDateTime(value.toString());
            } catch (ParseException e) {
                return null;
            }
        }
    }

    /**
     * 解析时间日期字符串为Date对象
     *
     * @param source
     * @return
     * @throws ParseException
     */
    private static Date parseDateTime(final String source) throws ParseException {
        return datetimeFormat.parse(source);
    }
}