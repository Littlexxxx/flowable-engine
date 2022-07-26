package cn.zswltech.preserver.core.audit;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.rule.RuleResult;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 5:35 下午
 * @description:
 **/
public class RuleEvalContext implements RuleExecuteContext {
    private RuleResult ruleResult;
    private final Map<String,Object> datas = new HashMap<>();

    public void refresh(Map<String,Object> datas,RuleResult ruleResult){
        this.ruleResult = ruleResult;
        this.datas.clear();
        this.datas.putAll(datas);
    }

    @Override
    public Object getField(String name) {
        return datas.get(name);
    }

    @Override
    public void setField(String name, Object value) {
        datas.put(name,value);
    }

    @Override
    public Map<String, Object> getOriginDatas() {
        return datas;
    }

    @Override
    public void saveDetail(DetailCallable detailCallable, String ruleName) {
        ruleResult.getDetailCallableMap().putIfAbsent(ruleName,new HashSet<DetailCallable>());
        ruleResult.getDetailCallableMap().get(ruleName).add(detailCallable);
    }
}
