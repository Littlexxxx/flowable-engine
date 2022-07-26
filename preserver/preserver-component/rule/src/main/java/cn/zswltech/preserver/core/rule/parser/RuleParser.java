package cn.zswltech.preserver.core.rule.parser;

import cn.zswltech.preserver.core.rule.common.RuleDetailEnum;
import cn.zswltech.preserver.core.rule.eval.EvalResult;
import cn.zswltech.preserver.core.rule.eval.Evaluable;
import cn.zswltech.preserver.core.rule.rule.Rule;
import cn.zswltech.preserver.core.rule.rule.RuleGroup;
import cn.zswltech.preserver.core.rule.rule.SimpleRule;
import cn.zswltech.preserver.core.rule.operator.rulegroup.RuleGroupOperator;
import cn.zswltech.preserver.core.rule.parser.factory.OperatorFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 10:21 上午
 * @description:
 **/
@Component
public class RuleParser {

    @Autowired
    private OperatorFactory operatorFactory;

    @Autowired
    SimpleRuleBuilder simpleRuleBuilder;

    public Rule ruleParser(String json){
        JSONObject rule = JSON.parseObject(json);
        JSONArray ja = rule.getJSONArray("ruleDetails");
        List<Evaluable<EvalResult>> ruleDetails = Lists.newArrayList();
        for (int i = 0; i < ja.size(); i++) {
            JSONObject ruleDetailJson = ja.getJSONObject(i);
            String type = ruleDetailJson.getString("type");
            JSONObject detail = ruleDetailJson.getJSONObject("detail");
            RuleDetailEnum ruleDetailEnum = RuleDetailEnum.get(type);
            if(Objects.equals(ruleDetailEnum,RuleDetailEnum.RuleGroup)){
                ruleDetails.add(ruleGroupBuild(detail));
            }else if(Objects.equals(ruleDetailEnum,RuleDetailEnum.SimpleRule)){
                ruleDetails.add(simpleRuleBuilder.build(detail));
            }
        }
        return Rule.builder()
                .evalList(ruleDetails)
                .build();
    }

    private RuleGroup ruleGroupBuild(JSONObject jb){
        String type = jb.getString("type");
        RuleGroupOperator ruleGroupOperator = (RuleGroupOperator) operatorFactory.getOperator(type);
        List<SimpleRule> simpleRuleList = Lists.newArrayList();
        JSONArray ja = jb.getJSONArray("rules");
        for (int i = 0; i < ja.size(); i++) {
            JSONObject ruleJson = ja.getJSONObject(i);
            simpleRuleList.add(simpleRuleBuilder.build(ruleJson));
        }
        return RuleGroup.builder()
                .ruleGroupOperator(ruleGroupOperator)
                .ruleList(simpleRuleList)
                .build();
    }
}
