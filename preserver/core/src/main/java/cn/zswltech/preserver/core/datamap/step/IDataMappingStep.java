package cn.zswltech.preserver.core.datamap.step;

import cn.tongdun.tdframework.core.pipeline.IStep;
import cn.zswltech.preserver.core.datamap.context.DataMappingContext;
import cn.zswltech.preserver.core.datamap.context.DataMappingResponse;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 2:57 下午
 * @description:
 **/
public interface IDataMappingStep extends IStep {

    boolean invoke(DataMappingContext context, DataMappingResponse result);
}
