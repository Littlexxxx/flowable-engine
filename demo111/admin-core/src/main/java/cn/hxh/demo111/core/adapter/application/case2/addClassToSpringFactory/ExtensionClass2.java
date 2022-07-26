package cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory;

import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2021/12/28 2:38 下午
 * @description:
 **/
@Data
public class ExtensionClass2 implements Extension{

    private String name = "class 2";

    public void say() {
        System.out.println(name + " class 2 to spring");
    }
}
