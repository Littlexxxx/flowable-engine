package cn.hxh.demo111.core.adapter.application.case2.addClassToSpringFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: xinhao.hu
 * @date: 2021/12/28 2:37 下午
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtensionClass1 implements Extension{



    private String name = "class 1";

    public void say(){
        System.out.println(name + " class 1 to spring");
    }
}
