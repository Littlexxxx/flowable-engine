package cn.zswltech.preserver.admin.middle.data.domain.before;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/5/20 11:22 上午
 * @description:
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtractDataBefore {
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
    private Integer orgId;

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
     * data json
     */
    private String data;

    /**
     * 拉取id
     */
    private int extractId;


    public void updateStatusAndExtractId(String status){
        this.status = status;
    }
}
