import cn.zswltech.preserver.core.cache.AuditRuleCache;
import cn.zswltech.preserver.core.cache.DataSourceModelCache;
import cn.zswltech.preserver.core.cache.ServiceConfigCache;
import cn.zswltech.preserver.core.extract.DataExtractEngine;
import cn.zswltech.preserver.core.extract.action.DataAuditActionCall;
import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.core.extract.context.ExtractResponse;
import cn.zswltech.preserver.core.extract.impl.LocalMiddleDataExtract;
import cn.zswltech.preserver.start.PreserverApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 3:55 下午
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PreserverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExtractTest {
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

    @Test
    public void test(){
        ExtractContext extractContext = new ExtractContext();
        ExtractResponse extractResponse = new ExtractResponse();

        extractContext.setServiceConfig(serviceConfigCache.get(1));
        extractContext.setDataSourceModel(dataSourceModelCache.get(1));
        extractContext.setExtractSelect("LOCAL");
        extractContext.setExtractType("increment");

        dataExtractEngine.extract(extractContext,extractResponse, dataAuditActionCall);

    }

    @Test
    public void testExcel(){
        ExtractContext extractContext = new ExtractContext();
        ExtractResponse extractResponse = new ExtractResponse();

        extractContext.setServiceConfig(serviceConfigCache.get(2));
        extractContext.setDataSourceModel(dataSourceModelCache.get(2));
        extractContext.setAuditRule(auditRuleCache.get(1));
        extractContext.setExtractSelect("FILE");
        extractContext.setExtractType("entire");

        dataExtractEngine.extract(extractContext,extractResponse, dataAuditActionCall);

    }

}
