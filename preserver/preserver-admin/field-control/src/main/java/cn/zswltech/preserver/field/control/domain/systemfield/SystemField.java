package cn.zswltech.preserver.field.control.domain.systemfield;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/5/9 7:52 下午
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SystemField {
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * code
     */
    private String code;

    /**
     * 数据类型
     */
    private Integer dataType;

    /**
     * 字段组
     */
    private Integer fieldGroupId;

    /**
     * 字段code简称
     */
    private String suffixName;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date gmtUpdate;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 描述
     */
    private String description;

    /**
     * 字段信息，如枚举类型的枚举值
     */
    private String fieldInfo;
}
