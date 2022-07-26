package cn.zswltech.preserver.core.extract.action;

import cn.zswltech.preserver.core.audit.AuditRequest;
import cn.zswltech.preserver.core.audit.AuditResponse;
import cn.zswltech.preserver.core.audit.DataAuditEngine;
import cn.zswltech.preserver.core.cache.AuditRuleCache;
import cn.zswltech.preserver.core.datamap.DataMappingEngine;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.core.extract.context.ExtractResponse;
import cn.zswltech.preserver.core.rule.rule.Rule;
import cn.zswltech.preserver.data.source.domain.DataSourceModel;
import org.apache.commons.compress.utils.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 5:05 下午
 * @description:
 **/
@Component
public class DataAuditActionCall implements ExtractActionCall {

    @Autowired
    private AuditRuleCache auditRuleCache;

    @Autowired
    private DataAuditEngine dataAuditEngine;

    @Autowired
    private DataMappingEngine dataMappingEngine;

    @Override
    public void call(ExtractContext context, ExtractResponse response) {
        List<Map<String, Object>> acceptData = Lists.newArrayList();
        if (context.getExtractDatas().size()==0) {
            return;
        }
        if(Objects.nonNull(context.getAuditRule())){
            Rule rule = context.getAuditRule().getRule();
            AuditRequest auditRequest = AuditRequest.builder()
                    .auditData(context.getExtractDatas())
                    .rule(rule)
                    .build();
            AuditResponse auditResponse = dataAuditEngine.audit(auditRequest);
            response.setAuditResponse(auditResponse);
            auditResponse.getAcceptData().forEach(t -> acceptData.add(t.getOriginData()));
        }else {
            acceptData.addAll(context.getExtractDatas());
        }

        DataMappingContext dataMappingContext = DataMappingContext.builder()
                .unExecuteDatas(acceptData)
                .executedDatas(Lists.newArrayList())
                .seviceConfig(context.getServiceConfig())
                .build();
        DataMappingResponse dataMappingResponse = dataMappingEngine.execute(dataMappingContext);
        response.setDataMappingResponse(dataMappingResponse);
    }

    @Override
    public String getName() {
        return "DataAudit";
    }
}
