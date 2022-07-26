package cn.zswltech.preserver.infrastructure.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "system_field")
public class SystemFieldDO {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "data_type")
    private Integer dataType;

    /**
     * 字段组
     */
    @Column(name = "field_group_id")
    private String fieldGroupId;

    /**
     * 字段code简称
     */
    @Column(name = "suffix_name")
    private String suffixName;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 更新时间
     */
    @Column(name = "gmt_update")
    private Date gmtUpdate;

    /**
     * 更新人
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 描述
     */
    private String description;

    /**
     * 字段信息，如枚举类型的枚举值
     */
    @Column(name = "field_info")
    private String fieldInfo;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名字
     *
     * @return name - 名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名字
     *
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取code
     *
     * @return code - code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置code
     *
     * @param code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取数据类型
     *
     * @return data_type - 数据类型
     */
    public Integer getDataType() {
        return dataType;
    }

    /**
     * 设置数据类型
     *
     * @param dataType 数据类型
     */
    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    /**
     * 获取字段组
     *
     * @return field_group_id - 字段组
     */
    public String getFieldGroupId() {
        return fieldGroupId;
    }

    /**
     * 设置字段组
     *
     * @param fieldGroupId 字段组
     */
    public void setFieldGroupId(String fieldGroupId) {
        this.fieldGroupId = fieldGroupId;
    }

    /**
     * 获取字段code简称
     *
     * @return suffix_name - 字段code简称
     */
    public String getSuffixName() {
        return suffixName;
    }

    /**
     * 设置字段code简称
     *
     * @param suffixName 字段code简称
     */
    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取更新时间
     *
     * @return gmt_update - 更新时间
     */
    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    /**
     * 设置更新时间
     *
     * @param gmtUpdate 更新时间
     */
    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    /**
     * 获取更新人
     *
     * @return updated_by - 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置更新人
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取描述
     *
     * @return description - 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置描述
     *
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取字段信息，如枚举类型的枚举值
     *
     * @return field_info - 字段信息，如枚举类型的枚举值
     */
    public String getFieldInfo() {
        return fieldInfo;
    }

    /**
     * 设置字段信息，如枚举类型的枚举值
     *
     * @param fieldInfo 字段信息，如枚举类型的枚举值
     */
    public void setFieldInfo(String fieldInfo) {
        this.fieldInfo = fieldInfo;
    }
}