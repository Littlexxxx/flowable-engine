package cn.zswltech.preserver.infrastructure.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "data_source")
public class DataSourceDO {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 描述
     */
    @Column(name = "`desc`")
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
     * 数据源配置
     */
    private String config;

    /**
     * 数据源字段元数据
     */
    @Column(name = "meta_data")
    private String metaData;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取描述
     *
     * @return desc - 描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置描述
     *
     * @param desc 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 获取数据源类型
     *
     * @return type - 数据源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置数据源类型
     *
     * @param type 数据源类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取所属公司
     *
     * @return org - 所属公司
     */
    public String getOrg() {
        return org;
    }

    /**
     * 设置所属公司
     *
     * @param org 所属公司
     */
    public void setOrg(String org) {
        this.org = org;
    }

    /**
     * 获取业务类型
     *
     * @return model - 业务类型
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置业务类型
     *
     * @param model 业务类型
     */
    public void setModel(String model) {
        this.model = model;
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
     * 获取数据源配置
     *
     * @return config - 数据源配置
     */
    public String getConfig() {
        return config;
    }

    /**
     * 设置数据源配置
     *
     * @param config 数据源配置
     */
    public void setConfig(String config) {
        this.config = config;
    }

    /**
     * 获取数据源字段元数据
     *
     * @return meta_data - 数据源字段元数据
     */
    public String getMetaData() {
        return metaData;
    }

    /**
     * 设置数据源字段元数据
     *
     * @param metaData 数据源字段元数据
     */
    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }
}