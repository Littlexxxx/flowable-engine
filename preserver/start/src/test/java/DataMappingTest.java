import cn.zswltech.preserver.core.cache.SystemFieldCache;
import cn.zswltech.preserver.core.datamap.DataMappingEngine;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.service.config.domain.MappingRelation;
import cn.zswltech.preserver.service.config.domain.ServiceConfig;
import cn.zswltech.preserver.start.PreserverApplication;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/19 11:27 上午
 * @description:
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PreserverApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DataMappingTest {

    @Autowired
    private DataMappingEngine dataMappingEngine;

    @Autowired
    private SystemFieldCache systemFieldCache;

    @Test
    public void testMapping(){
        DataMappingContext dataMappingContext = new DataMappingContext();
        DataMappingResponse dataMappingResponse = new DataMappingResponse();
        ServiceConfig serviceConfig = new ServiceConfig();
        serviceConfig.setServiceCode("test");
        Map<String,MappingRelation> relations = new HashMap<>();
        SystemField systemField = new SystemField();
        systemField.setCode("S_S_ORGCODE");
        systemFieldCache.put("S_S_ORGCODE",systemField);
        serviceConfig.setMappingConfig(JSON.toJSONString(relations));
        List<Map<String,Object>> list = new ArrayList<>();
        for(int i=1;i<=10;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("aaa"+i,"23434");
            list.add(map);
            MappingRelation mappingRelation = new MappingRelation();
            mappingRelation.setOriginName("aaa"+i);
            mappingRelation.setMappingName("S_S_ORGCODE");
            relations.put(mappingRelation.getOriginName(),mappingRelation);
        }
        List<Map<SystemField,Object>> res = new ArrayList<>();

        dataMappingContext.setUnExecuteDatas(list);
        dataMappingContext.setSeviceConfig(serviceConfig);
        dataMappingContext.setExecutedDatas(res);

        dataMappingEngine.execute(dataMappingContext);
    }


}
