package cn.zswltech.preserver.data.source.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/5/13 9:53 上午
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataSourceModel {
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    private String desc;

    /**
     * 数据源类型
     */
    private String type;

    /**
     * 所属公司
     */
    private String org;

    /**
     * 业务类型
     */
    private String model;

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

//    /**
//     * 数据库名
//     */
//    private String databaseName;
//
//    /**
//     * 表名
//     */
//    private String tableName;

    /**
     * 数据源配置
     */
    private String config;

    /**
     * 数据源字段元数据
     */
    private String metaData;
}
