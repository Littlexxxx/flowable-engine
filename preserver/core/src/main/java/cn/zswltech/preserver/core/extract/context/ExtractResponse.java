package cn.zswltech.preserver.core.extract.context;

import cn.zswltech.preserver.core.audit.AuditResponse;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import cn.zswltech.preserver.core.datamap.step.mapping.DataMappingStep;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 4:54 下午
 * @description:
 **/
@Data
public class ExtractResponse {

    private AuditResponse auditResponse;

    private DataMappingResponse dataMappingResponse;

    private List<Map<String,Object>> extractDatas;
}
