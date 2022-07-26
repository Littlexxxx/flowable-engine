package cn.hxh.demo111.core.adapter.application.case1.proxy1;

import java.lang.reflect.InvocationTargetException;

public class MyInterceptor implements Interceptor {

	public boolean before() {
		System.out.println("before ......");
		return true;
	}

	public boolean useAround() {
		return true;
	}

	public void after() {
		System.out.println("after ......");
	}

	public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
		System.out.println("around before ......");
		Object obj = invocation.doInvocation();
		System.out.println("around after ......");
		return obj;
	}

	public void afterReturning() {
		System.out.println("afterReturning......");

	}

	public void afterThrowing() {
		System.out.println("afterThrowing 。。。。。。");
	}

}
