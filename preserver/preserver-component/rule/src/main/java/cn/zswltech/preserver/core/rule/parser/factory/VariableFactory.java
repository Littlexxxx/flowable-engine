package cn.zswltech.preserver.core.rule.parser.factory;

import cn.zswltech.preserver.core.rule.exception.ParseException;
import cn.zswltech.preserver.core.rule.operator.common.Operator;
import cn.zswltech.preserver.core.rule.variable.Variable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 11:27 上午
 * @description:
 **/
@Component
public class VariableFactory {
    private Map<String, Class<? extends Variable>> variableMap = new HashMap<>();

    @PostConstruct
    public void init(){
        ServiceLoader<Variable> serviceLoader = ServiceLoader.load(Variable.class);
        serviceLoader.forEach(t -> variableMap.put(t.getType(),t.getClass()));
    }

    public Variable getVariable(String name){
        Class<? extends Variable> clazz = variableMap.get(name);
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ParseException("operator get error!",e);
        }
    }

    public void putVariable(Variable operator){
        variableMap.putIfAbsent(operator.getType(),operator.getClass());
    }
}
