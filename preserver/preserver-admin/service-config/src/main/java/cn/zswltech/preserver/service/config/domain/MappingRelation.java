package cn.zswltech.preserver.service.config.domain;

import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 3:52 下午
 * @description:
 **/
@Data
public class MappingRelation {
    private String originName;

    private String mappingName;

    private String dataType;

    private Object defaultValue;

    private boolean hasDefaultValue;
}
