package cn.zswltech.preserver.core.rule.variable.function;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;
import cn.zswltech.preserver.core.rule.rule.detail.FunctionDetail;
import cn.zswltech.preserver.core.rule.variable.Variable;
import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 2:58 下午
 * @description:
 **/
@Data
public class Function implements Variable {

    protected String functionExpression;

    @Override
    public Object eval(RuleExecuteContext ruleExecuteContext) {
        return null;
    }

    @Override
    public String getType() {
        return "function";
    }

    @Override
    public DetailCallable getDetail(Object value) {
        FunctionDetail detail = new FunctionDetail();
        detail.setFunctionExpression(functionExpression);
        detail.setValue(value);
        return () -> detail;
    }

}
