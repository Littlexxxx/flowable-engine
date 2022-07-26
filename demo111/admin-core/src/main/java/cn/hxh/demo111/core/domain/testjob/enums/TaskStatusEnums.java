package cn.hxh.demo111.core.domain.testjob.enums;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:30 下午
 * @description:
 **/
@AllArgsConstructor
@Getter
public enum TaskStatusEnums {
    Start("start",1,"开始"),
    Running("running",5,"运行中"),
    Finish("finish",10,"已完成");

    private String name;
    private int value;
    private String desc;

    public static TaskStatusEnums getByValue(int value){
        for(TaskStatusEnums enums : TaskStatusEnums.values()){
            if(Objects.equal(enums.getValue(),value)){
                return enums;
            }
        }
        return null;
    }
}
