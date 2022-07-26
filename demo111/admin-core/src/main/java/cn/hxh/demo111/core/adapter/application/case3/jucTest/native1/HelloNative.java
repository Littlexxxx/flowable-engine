package cn.hxh.demo111.core.adapter.application.case3.jucTest.native1;

/**
 * @author: xinhao.hu
 * @date: 2021/12/31 3:17 下午
 * @description:
 **/
public class HelloNative {
    public native String HelloNative();

    static{
        //不写文件的后缀，程序会自动加上.dll的。
        System.loadLibrary("hello");
    }

    public static void main(String[] args){
        String word = new HelloNative().HelloNative();
        System.out.println(word);
    }

}
