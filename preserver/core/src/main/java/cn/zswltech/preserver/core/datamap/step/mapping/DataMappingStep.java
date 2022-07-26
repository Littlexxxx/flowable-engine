package cn.zswltech.preserver.core.datamap.step.mapping;

import cn.tongdun.tdframework.core.pipeline.Step;
import cn.zswltech.preserver.core.cache.SystemFieldCache;
import cn.zswltech.preserver.core.datamap.DataMappingPipeline;
import cn.zswltech.preserver.core.datamap.step.IDataMappingStep;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import cn.zswltech.preserver.field.control.domain.systemfield.SystemField;
import cn.zswltech.preserver.service.config.domain.MappingRelation;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 3:02 下午
 * @description:
 **/
@Step(pipeline = DataMappingPipeline.NAME,phase = DataMappingPipeline.MAPPING,order = 2200)
public class DataMappingStep implements IDataMappingStep {

    @Autowired
    private SystemFieldCache systemFieldCache;

    @Override
    public boolean invoke(DataMappingContext context, DataMappingResponse result) {
        try{
            dataMapping(context,result);
            return true;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private void dataMapping(DataMappingContext context, DataMappingResponse result){
        List<Map<SystemField,Object>> mappingDatas = Lists.newArrayList();
        Map<String,MappingRelation> relations = context.getSeviceConfig().getMappingConfigModel();
        for (Map<String,Object> data : context.getUnExecuteDatas()){
            Map<SystemField,Object> mappingData = new HashMap<>();
            for (Map.Entry<String,Object> entry : data.entrySet()){
                if(Objects.isNull(relations.get(entry.getKey()))){
                    continue;
                }
                SystemField key = systemFieldCache.get(relations.get(entry.getKey()).getMappingName());
                // TODO 根据systemField 转数据类型？
                mappingData.put(key,entry.getValue());
            }
            mappingDatas.add(mappingData);
        }
        context.getExecutedDatas().addAll(mappingDatas);
    }
}
