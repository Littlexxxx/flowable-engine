package cn.zswltech.preserver.core.rule.eval;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 11:40 上午
 * @description:
 **/
public interface Evaluable<T> {

    T eval(RuleExecuteContext ruleExecuteContext);
}
