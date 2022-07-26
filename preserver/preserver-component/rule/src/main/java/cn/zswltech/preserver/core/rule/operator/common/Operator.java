package cn.zswltech.preserver.core.rule.operator.common;

import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 11:14 上午
 * @description:
 **/
public interface Operator extends Evaluable<EvalResult> {
    String getName();
}
