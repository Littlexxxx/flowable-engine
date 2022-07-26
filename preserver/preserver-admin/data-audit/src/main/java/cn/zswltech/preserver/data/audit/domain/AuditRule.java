package cn.zswltech.preserver.data.audit.domain;

import cn.zswltech.preserver.core.rule.rule.Rule;
import lombok.Data;

import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/5/24 6:02 下午
 * @description:
 **/
@Data
public class AuditRule {
    private Integer id;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 数据源id
     */
    private Integer datasourceId;

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
     * 规则详情json
     */
    private String ruleDetail;

    /**
     * 规则
     */
    private Rule rule;
}
