package cn.zswltech.preserver.infrastructure.dataobject;

import java.util.Date;
import javax.persistence.*;

@Table(name = "extract_data_before")
public class ExtractDataBeforeDO {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 当前中间数据状态
     */
    private String status;

    /**
     * 业务领域
     */
    private String model;

    /**
     * 机构
     */
    @Column(name = "org_id")
    private Integer orgId;

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
     * 具体数据
     */
    @Column(name = "`data`")
    private String data;

    /**
     * 具体数据
     */
    @Column(name = "extract_id")
    private String extractId;

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
     * 获取当前中间数据状态
     *
     * @return status - 当前中间数据状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置当前中间数据状态
     *
     * @param status 当前中间数据状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取业务领域
     *
     * @return model - 业务领域
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置业务领域
     *
     * @param model 业务领域
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取机构
     *
     * @return org_id - 机构
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * 设置机构
     *
     * @param orgId 机构
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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
     * 获取具体数据
     *
     * @return data - 具体数据
     */
    public String getData() {
        return data;
    }

    /**
     * 设置具体数据
     *
     * @param data 具体数据
     */
    public void setData(String data) {
        this.data = data;
    }

    public String getExtractId() {
        return extractId;
    }

    public void setExtractId(String extractId) {
        this.extractId = extractId;
    }
}