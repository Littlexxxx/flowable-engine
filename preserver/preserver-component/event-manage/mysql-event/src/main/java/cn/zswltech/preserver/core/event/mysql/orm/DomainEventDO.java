package cn.zswltech.preserver.core.event.mysql.orm;

import java.util.Date;
import javax.persistence.*;

@Table(name = "domain_event")
public class DomainEventDO {
    /**
     * 主键id自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 唯一标识
     */
    private String uuid;

    /**
     * 事件类型
     */
    @Column(name = "event_type")
    private String eventType;

    /**
     * 实体类型
     */
    private String entity;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 更新者
     */
    private String operator;

    /**
     * 实体唯一标识
     */
    @Column(name = "entity_uuid")
    private String entityUuid;

    /**
     * 事件发生时间
     */
    @Column(name = "occurred_time")
    private Long occurredTime;

    /**
     * 事件数据
     */
    @Column(name = "event_data")
    private String eventData;

    /**
     * 获取主键id自增
     *
     * @return id - 主键id自增
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id自增
     *
     * @param id 主键id自增
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取唯一标识
     *
     * @return uuid - 唯一标识
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * 设置唯一标识
     *
     * @param uuid 唯一标识
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * 获取事件类型
     *
     * @return event_type - 事件类型
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * 设置事件类型
     *
     * @param eventType 事件类型
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    /**
     * 获取实体类型
     *
     * @return entity - 实体类型
     */
    public String getEntity() {
        return entity;
    }

    /**
     * 设置实体类型
     *
     * @param entity 实体类型
     */
    public void setEntity(String entity) {
        this.entity = entity;
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
     * 获取修改时间
     *
     * @return gmt_modify - 修改时间
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModify 修改时间
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    /**
     * 获取创建者
     *
     * @return creator - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取更新者
     *
     * @return operator - 更新者
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置更新者
     *
     * @param operator 更新者
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * 获取实体唯一标识
     *
     * @return entity_uuid - 实体唯一标识
     */
    public String getEntityUuid() {
        return entityUuid;
    }

    /**
     * 设置实体唯一标识
     *
     * @param entityUuid 实体唯一标识
     */
    public void setEntityUuid(String entityUuid) {
        this.entityUuid = entityUuid;
    }

    /**
     * 获取事件发生时间
     *
     * @return occurred_time - 事件发生时间
     */
    public Long getOccurredTime() {
        return occurredTime;
    }

    /**
     * 设置事件发生时间
     *
     * @param occurredTime 事件发生时间
     */
    public void setOccurredTime(Long occurredTime) {
        this.occurredTime = occurredTime;
    }

    /**
     * 获取事件数据
     *
     * @return event_data - 事件数据
     */
    public String getEventData() {
        return eventData;
    }

    /**
     * 设置事件数据
     *
     * @param eventData 事件数据
     */
    public void setEventData(String eventData) {
        this.eventData = eventData;
    }
}