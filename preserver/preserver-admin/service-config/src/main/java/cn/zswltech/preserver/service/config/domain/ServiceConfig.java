package cn.zswltech.preserver.service.config.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/10 2:11 下午
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceConfig {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名字
     */
    private String name;

    /**
     * code
     */
    private String serviceCode;

    /**
     * 是否被删除
     */
    private String isDelete;

    /**
     * 数据源类型
     */
    private String datasourceType;

    /**
     * 数据源id
     */
    private Integer datasourceId;

    /**
     * service类型
     */
    private String serviceType;

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
     * 业务类型
     */
    private String model;

    /**
     * 映射关系
     */
    private String mappingConfig;

    /**
     * 映射关系实体
     */
    private Map<String,MappingRelation> mappingConfigModel;
}
