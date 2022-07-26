package cn.zswltech.preserver.field.control.domain.fieldgroup;

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
public class FieldGroup {
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * code
     */
    private String code;

    /**
     * 描述
     */
    private String desc;

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

    public void update(String name,String code,String desc,String operator){
        this.name = name;
        this.code = code;
        this.desc = desc;
        this.updatedBy = operator;
    }



}
