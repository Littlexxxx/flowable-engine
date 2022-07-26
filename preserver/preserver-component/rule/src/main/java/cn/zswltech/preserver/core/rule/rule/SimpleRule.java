package cn.zswltech.preserver.core.rule.rule;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;
import lombok.Builder;
import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 10:04 上午
 * @description:
 **/
@Data
@Builder
public class SimpleRule implements Evaluable<EvalResult>{
    private String name;
    private Evaluable<EvalResult> eval;

    @Override
    public EvalResult eval(RuleExecuteContext context){
        return eval.eval(context);
    }
}
