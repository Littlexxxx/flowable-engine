package cn.zswltech.preserver.core.extract.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: xinhao.hu
 * @date: 2022/5/19 11:00 上午
 * @description:
 **/
@Getter
@AllArgsConstructor
public enum ExtractTypeEnum {
    LOCAL,
    MYSQL,
    FILE,
    ;

    public static ExtractTypeEnum getExtractType(String name){
        return ExtractTypeEnum.valueOf(name);
    }
}
