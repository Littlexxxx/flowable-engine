package cn.hxh.demo111.core.adapter.application.case3.jucTest.cas;

/**
 * @author: xinhao.hu
 * @date: 2021/12/31 11:43 上午
 * @description:
 **/
public class Test1 {
    public static void main(String[] args) {
        try{
            Unsafe unsafe = new Unsafe(1);
            unsafe.addWithCAS(2);
            System.out.println(unsafe.getValue());
        }catch (Exception e){
        }

    }
}
