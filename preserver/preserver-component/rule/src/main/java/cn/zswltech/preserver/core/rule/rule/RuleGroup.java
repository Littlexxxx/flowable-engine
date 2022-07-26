package cn.zswltech.preserver.core.rule.rule;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;
import cn.zswltech.preserver.core.rule.operator.rulegroup.RuleGroupOperator;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 10:04 上午
 * @description:
 **/
@Data
@Builder
@AllArgsConstructor
public class RuleGroup implements Evaluable<EvalResult> {
    private RuleGroupOperator ruleGroupOperator;
    private List<SimpleRule> ruleList;

    @Override
    public EvalResult eval(RuleExecuteContext context) {
        List<EvalResult> results = Lists.newArrayList();
        for (SimpleRule rule : ruleList) {
            results.add(rule.eval(context));
        }
        ruleGroupOperator.setOperandResult(results);
        return ruleGroupOperator.eval(context);
    }


}
