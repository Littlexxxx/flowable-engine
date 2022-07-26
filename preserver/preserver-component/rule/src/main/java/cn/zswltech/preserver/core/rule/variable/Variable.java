package cn.zswltech.preserver.core.rule.variable;

import cn.zswltech.preserver.core.rule.eval.Evaluable;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 11:41 上午
 * @description:
 **/
public interface Variable extends Evaluable<Object> {
    String getType();

    /**
     * 补充详情接口 abstractFunction return null
     * @return
     */
    DetailCallable getDetail(Object value);
}
