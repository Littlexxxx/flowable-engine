package cn.zswltech.preserver.client.xxljob;

import cn.zswltech.preserver.core.cache.AuditRuleCache;
import cn.zswltech.preserver.core.cache.DataSourceModelCache;
import cn.zswltech.preserver.core.cache.ServiceConfigCache;
import cn.zswltech.preserver.core.extract.DataExtractEngine;
import cn.zswltech.preserver.core.extract.action.DataAuditActionCall;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.core.extract.context.ExtractResponse;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author: xinhao.hu
 * @date: 2022/5/31 3:23 下午
 * @description:
 **/
@Component
public class DataExtractHandler {

    @Autowired
    private DataSourceModelCache dataSourceModelCache;

    @Autowired
    private ServiceConfigCache serviceConfigCache;

    @Autowired
    private AuditRuleCache auditRuleCache;

    @Autowired
    private DataExtractEngine dataExtractEngine;

    @Autowired
    private DataAuditActionCall dataAuditActionCall;


    @XxlJob("dataExtractHandler")
    public void dataExtract(){
        while(true){
            ExtractContext extractContext = new ExtractContext();
            ExtractResponse extractResponse = new ExtractResponse();

            extractContext.setServiceConfig(serviceConfigCache.get(1));
            extractContext.setDataSourceModel(dataSourceModelCache.get(1));
            extractContext.setExtractSelect("LOCAL");
            extractContext.setExtractType("increment");

            dataExtractEngine.extract(extractContext,extractResponse, dataAuditActionCall);
            if(extractContext.getExtractDatas().isEmpty()){
                break;
            }
        }
    }
}
