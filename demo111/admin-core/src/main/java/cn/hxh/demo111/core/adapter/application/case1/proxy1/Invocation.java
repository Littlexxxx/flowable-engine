package cn.hxh.demo111.core.adapter.application.case1.proxy1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: xinhao.hu
 * @date: 2021/12/27 10:51 上午
 * @description:
 **/
@Data
@AllArgsConstructor
public class Invocation {
    public Object[] params;
    public Method method;
    /**
     * 被代理对象
     */
    public Object target;
    public Object doInvocation() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(params);
    }

}
