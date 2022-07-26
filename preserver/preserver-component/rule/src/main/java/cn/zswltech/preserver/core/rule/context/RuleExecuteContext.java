package cn.zswltech.preserver.core.rule.context;

import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 11:40 上午
 * @description:
 **/
public interface RuleExecuteContext {
    Object getField(String name);

    void setField(String name, Object value);

    Map<String,Object> getOriginDatas();

    void saveDetail(DetailCallable detailCallable,String ruleName);
}
