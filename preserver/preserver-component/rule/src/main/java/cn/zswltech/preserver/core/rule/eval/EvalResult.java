package cn.zswltech.preserver.core.rule.eval;

import cn.zswltech.preserver.core.rule.exception.ParseException;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 2:01 下午
 * @description:
 **/
public enum EvalResult {
    /**
     * 规则的评价结果
     */
    Unknown, Exception, True, False, Terminate;

    public static EvalResult valueOf(Boolean value) {
        if (null == value) {
            return Unknown;
        }
        if (value) {
            return True;
        }
        return False;
    }

    public static EvalResult valueOf(Object object) {
        if (null == object) {
            return EvalResult.Unknown;
        }
        if (object instanceof EvalResult) {
            return (EvalResult) object;
        }
        if (object instanceof Boolean) {
            Boolean value = (Boolean) object;
            if (value) {
                return True;
            }
            return False;
        } else {
            throw new ParseException("EvalResult error,value is " + object.toString());
        }
    }

}

