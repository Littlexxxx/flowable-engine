package cn.zswltech.preserver.core.extract.context;

import cn.zswltech.preserver.data.audit.domain.AuditRule;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 4:54 下午
 * @description: 拉取上下文
 **/
@Data
public class ExtractContext {

    /**
     * 拉取类型
     */
    private String extractType;

    /**
     * 拉取类型，选择增量拉取或全量拉取
     */
    private String extractSelect;

    /**
     * 数据源model
     */
    private DataSourceModel dataSourceModel;

    /**
     * 映射配置
     */
    private ServiceConfig serviceConfig;

    /**
     * 已拉取数据
     * key->name,value->value
     */
    private List<Map<String,Object>> extractDatas;

    /**
     * 配置规则
     */
    private AuditRule auditRule;
}
