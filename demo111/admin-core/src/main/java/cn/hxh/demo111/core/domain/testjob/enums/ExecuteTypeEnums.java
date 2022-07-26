package cn.hxh.demo111.core.domain.testjob.enums;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: xinhao.hu
 * @date: 2022/1/26 4:31 下午
 * @description:
 **/
@AllArgsConstructor
@Getter
public enum ExecuteTypeEnums {
    Once("now",10,"立即执行一次"),
    More("more",20,"定时执行");

    private String name;
    private int value;
    private String desc;

    public static ExecuteTypeEnums getByValue(int value){
        for(ExecuteTypeEnums enums : ExecuteTypeEnums.values()){
            if(Objects.equal(enums.getValue(),value)){
                return enums;
            }
        }
        return null;
    }
}
