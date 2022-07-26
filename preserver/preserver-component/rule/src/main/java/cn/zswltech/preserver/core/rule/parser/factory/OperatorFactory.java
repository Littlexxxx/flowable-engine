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
 * @date: 2022/5/16 11:26 上午
 * @description:
 **/
@Component
public class OperatorFactory {
    private Map<String, Class<? extends Operator>> operatorMap = new HashMap<>();

    @PostConstruct
    public void init(){
        ServiceLoader<Operator> serviceLoader = ServiceLoader.load(Operator.class);
        serviceLoader.forEach(t -> operatorMap.put(t.getName(),t.getClass()));
    }

    public Operator getOperator(String name){
        Class<? extends Operator> clazz = operatorMap.get(name);
        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new ParseException("operator get error!",e);
        }
    }

    public void putOperator(Operator operator){
        operatorMap.putIfAbsent(operator.getName(),operator.getClass());
    }
}
