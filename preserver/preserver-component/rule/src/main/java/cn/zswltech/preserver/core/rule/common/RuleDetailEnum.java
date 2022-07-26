package cn.zswltech.preserver.core.rule.common;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 2:19 下午
 * @description:
 **/
public enum RuleDetailEnum {
    RuleGroup,
    SimpleRule,
    Unknown
    ;

    public static RuleDetailEnum get(String name){
        RuleDetailEnum ruleDetailEnum = RuleDetailEnum.valueOf(name);
        if (ruleDetailEnum == null){
            return Unknown;
        }
        return ruleDetailEnum;
    }
}
