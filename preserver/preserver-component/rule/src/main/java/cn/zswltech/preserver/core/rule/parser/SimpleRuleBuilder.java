package cn.zswltech.preserver.core.rule.parser;

import cn.zswltech.preserver.core.rule.exception.ParseException;
import cn.zswltech.preserver.core.rule.rule.SimpleRule;
import cn.zswltech.preserver.core.rule.operator.AbstractBinaryOperator;
import cn.zswltech.preserver.core.rule.operator.AbstractUnaryOperator;
import cn.zswltech.preserver.core.rule.operator.common.Operator;
import cn.zswltech.preserver.core.rule.parser.factory.OperatorFactory;
import cn.zswltech.preserver.core.rule.parser.factory.VariableFactory;
import cn.zswltech.preserver.core.rule.variable.Variable;
import cn.zswltech.preserver.core.rule.variable.consts.Const;
import cn.zswltech.preserver.core.rule.variable.field.Field;
import cn.zswltech.preserver.core.rule.variable.function.Function;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 10:28 上午
 * @description:
 **/
@Component
public class SimpleRuleBuilder {

    @Autowired
    private OperatorFactory operatorFactory;

    @Autowired
    private VariableFactory variableFactory;

    public SimpleRule build(JSONObject jb){
        try{
            String name = jb.getString("ruleName");

            String op = jb.getString("op");
            Operator operator = operatorFactory.getOperator(op);

            if(operator instanceof AbstractBinaryOperator){
                Variable leftVar = buildVariable(jb.getJSONObject("leftVar"));
                Variable rightVar = buildVariable(jb.getJSONObject("rightVar"));
                ((AbstractBinaryOperator) operator).setLeftVar(leftVar);
                ((AbstractBinaryOperator) operator).setRightVar(rightVar);
                ((AbstractBinaryOperator) operator).setRuleName(name);
            }else if(operator instanceof AbstractUnaryOperator){
                Variable leftVar = buildVariable(jb.getJSONObject("leftVar"));
                ((AbstractUnaryOperator) operator).setLeftVar(leftVar);
                ((AbstractBinaryOperator) operator).setRuleName(name);
            }
            return SimpleRule.builder()
                    .eval(operator)
                    .build();

        }catch (Exception e){
            throw new ParseException("rule parser error! ",e);
        }

    }

    private Variable buildVariable(JSONObject json){
        String type = json.getString("type");
        Variable variable = variableFactory.getVariable(type);
        if (variable instanceof Field){
            ((Field) variable).setName(json.getString("name"));
            ((Field) variable).setDataType(json.getString("dataType"));
        }else if (variable instanceof Const){
            ((Const) variable).setConsts(json.getString("value"));
            ((Const) variable).setDataType(json.getString("dataType"));
        }else if(variable instanceof Function){
            ((Function) variable).setFunctionExpression(json.getString("function"));
        }
        return variable;
    }


}
