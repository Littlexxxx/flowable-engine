package cn.zswltech.preserver.core.rule.rule;

import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;
import cn.zswltech.preserver.core.rule.rule.detail.IDetail;
import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class RuleResult {

    private Map<String,Object> originData;

    private EvalResult evalResult;
    /**
     * 规则执行的抛出的异常
     */
    private Exception exception;
    /**
     *耗时
     */
    private long cost;
    /**
     * 规则详情
     */
    private Map<String,Set<DetailCallable>> detailCallableMap = new HashMap<>();
}