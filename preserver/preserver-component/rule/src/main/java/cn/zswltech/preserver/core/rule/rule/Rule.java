package cn.zswltech.preserver.core.rule.rule;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;
import cn.zswltech.preserver.core.rule.operator.rulegroup.And;
import cn.zswltech.preserver.core.rule.operator.rulegroup.RuleGroupOperator;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 10:03 上午
 * @description:
 **/
@Data
@Builder
public class Rule {
    private RuleGroupOperator defaultOperator;
    private List<Evaluable<EvalResult>> evalList;

    public EvalResult execute(RuleExecuteContext context){
        List<EvalResult> results = Lists.newArrayList();
        for (Evaluable<EvalResult> eval : evalList){
            results.add(eval.eval(context));
        }
        defaultOperator = new And();
        defaultOperator.setOperandResult(results);
        return defaultOperator.eval(context);
    }
}
