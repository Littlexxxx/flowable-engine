package cn.zswltech.preserver.infrastructure.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "service_config")
public class ServiceConfigDO {
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
    @Column(name = "service_code")
    private String serviceCode;

    /**
     * 是否被删除
     */
    @Column(name = "is_delete")
    private String isDelete;

    /**
     * 数据源类型
     */
    @Column(name = "datasource_type")
    private String datasourceType;

    /**
     * 数据源id
     */
    @Column(name = "datasource_id")
    private Integer datasourceId;

    /**
     * service类型
     */
    @Column(name = "service_type")
    private String serviceType;

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
     * 业务类型
     */
    private String model;

    /**
     * 映射关系
     */
    @Column(name = "mapping_config")
    private String mappingConfig;

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
     * @return service_code - code
     */
    public String getServiceCode() {
        return serviceCode;
    }

    /**
     * 设置code
     *
     * @param serviceCode code
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 获取是否被删除
     *
     * @return is_delete - 是否被删除
     */
    public String getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否被删除
     *
     * @param isDelete 是否被删除
     */
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取数据源类型
     *
     * @return datasource_type - 数据源类型
     */
    public String getDatasourceType() {
        return datasourceType;
    }

    /**
     * 设置数据源类型
     *
     * @param datasourceType 数据源类型
     */
    public void setDatasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
    }

    /**
     * 获取数据源id
     *
     * @return datasource_id - 数据源id
     */
    public Integer getDatasourceId() {
        return datasourceId;
    }

    /**
     * 设置数据源id
     *
     * @param datasourceId 数据源id
     */
    public void setDatasourceId(Integer datasourceId) {
        this.datasourceId = datasourceId;
    }

    /**
     * 获取service类型
     *
     * @return service_type - service类型
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 设置service类型
     *
     * @param serviceType service类型
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
     * 获取映射关系
     *
     * @return mapping_config - 映射关系
     */
    public String getMappingConfig() {
        return mappingConfig;
    }

    /**
     * 设置映射关系
     *
     * @param mappingConfig 映射关系
     */
    public void setMappingConfig(String mappingConfig) {
        this.mappingConfig = mappingConfig;
    }
}