package cn.zswltech.preserver.core.datamap;

import cn.tongdun.tdframework.core.pipeline.PipelineExecutor;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;
import cn.zswltech.preserver.core.datamap.step.IDataMappingStep;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: xinhao.hu
 * @date: 2022/5/19 11:28 上午
 * @description:
 **/
@Slf4j
@Component
public class DataMappingEngine {
    @Autowired
    private PipelineExecutor pipelineExecutor;

    public DataMappingResponse execute(DataMappingContext context){
        DataMappingResponse result = new DataMappingResponse();
        String pipelineName = DataMappingPipeline.NAME;
        try {
            pipelineExecutor.execute(pipelineName, IDataMappingStep.class,
                    step -> step.invoke(context, result), (isSuccess, throwable) -> {
                        if (throwable != null) {
                            log.error("数据映射异常!", throwable);
                        }
                        return isSuccess != null && !isSuccess;
                    }
            );
        } catch (Exception e) {
            log.error("数据映射异常! context:{}", JSON.toJSONString(context, SerializerFeature.DisableCircularReferenceDetect), e);
            DataMappingResponse errorResult = new DataMappingResponse();
            return errorResult;
        }
        return result;
    }
}
