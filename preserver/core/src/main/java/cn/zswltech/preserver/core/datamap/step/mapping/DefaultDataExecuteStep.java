package cn.zswltech.preserver.core.datamap.step.mapping;

import cn.tongdun.tdframework.core.pipeline.Step;
import cn.zswltech.preserver.core.datamap.DataMappingPipeline;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import cn.zswltech.preserver.core.datamap.step.IDataMappingStep;
import cn.zswltech.preserver.service.config.domain.MappingRelation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 3:05 下午
 * @description:
 **/
@Step(pipeline = DataMappingPipeline.NAME, phase = DataMappingPipeline.MAPPING, order = 2100)
public class DefaultDataExecuteStep implements IDataMappingStep {
    @Override
    public boolean invoke(DataMappingContext context, DataMappingResponse result) {
        try{
            setDefaultData(context,result);
            return true;
        }catch (Exception e){
            //TODO
            return false;
        }
    }

    private void setDefaultData(DataMappingContext context, DataMappingResponse result) {
        Map<String,MappingRelation> mappingRelations = context.getSeviceConfig().getMappingConfigModel();
        List<MappingRelation> needExecuteDefault = mappingRelations.values().stream()
                .filter(MappingRelation::isHasDefaultValue)
                .collect(Collectors.toList());
        for (Map<String, Object> map : context.getUnExecuteDatas()) {
            for (MappingRelation relation : needExecuteDefault) {
                if (map.get(relation.getOriginName()) == null){
                    map.put(relation.getOriginName(),relation.getDefaultValue());
                }
            }
        }
        return;
    }
}
