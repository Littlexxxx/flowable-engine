package cn.hxh.demo111.core.adapter.application.case1.proxy1;

/**
 * @author: xinhao.hu
 * @date: 2021/12/27 11:44 上午
 * @description:
 **/
public class Test1 {
    public static void main(String[] args) {
        HelloSay hello = new HelloSayImpl();
        HelloSay proxy = (HelloSay)ProxyBean.getProxyBean(hello,new MyInterceptor());
        proxy.sayHello();
    }
}
