package cn.zswltech.preserver.core.datamap.step.action;

import cn.tongdun.tdframework.core.pipeline.Step;
import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfter;
import cn.zswltech.preserver.admin.middle.data.domain.after.ExtractDataAfterRepository;
import cn.zswltech.preserver.core.datamap.DataMappingPipeline;
import cn.zswltech.preserver.core.datamap.step.IDataMappingStep;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 3:11 下午
 * @description:
 **/
@Step(pipeline = DataMappingPipeline.NAME,phase = DataMappingPipeline.ACTION,order = 3100)
public class DataSaveStep implements IDataMappingStep {

    @Autowired
    private ExtractDataAfterRepository extractDataAfterRepository;

    @Override
    public boolean invoke(DataMappingContext context, DataMappingResponse result) {
        ExtractDataAfter extractDataAfter = buildMiddleDataAfter(context);
        extractDataAfterRepository.create(extractDataAfter);
        return true;
    }


    private ExtractDataAfter buildMiddleDataAfter(DataMappingContext context){
        ExtractDataAfter extractDataAfter = new ExtractDataAfter();
        String jsonDatas = JSON.toJSONString(context.getExecutedDatas(), SerializerFeature.DisableCircularReferenceDetect);
        extractDataAfter.init(context.getExtractId(),null,null,jsonDatas);
        return extractDataAfter;
    }
}
