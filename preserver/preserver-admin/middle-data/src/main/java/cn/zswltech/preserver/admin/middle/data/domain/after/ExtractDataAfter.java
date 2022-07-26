package cn.zswltech.preserver.admin.middle.data.domain.after;

import lombok.Data;
import java.util.Date;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 5:01 下午
 * @description:
 **/
@Data
public class ExtractDataAfter {
    private Integer id;

    /**
     * extarct_id
     */
    private Integer extractId;

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
    private String org;

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
     * 具体数据
     */
    private String data;

    /**
     * 创建
     * @param extractId
     * @param model
     * @param org
     * @param data
     * @return
     */
    public void init(Integer extractId,String model,String org,String data){
        this.extractId = extractId;
        this.model = model;
        this.org = org;
        this.data = data;
    }
}
