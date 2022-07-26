package cn.zswltech.preserver.core.datamap;

import cn.tongdun.tdframework.core.pipeline.Phase;
import cn.tongdun.tdframework.core.pipeline.Pipeline;

/**
 * @author: xinhao.hu
 * @date: 2022/5/18 2:14 下午
 * @description:
 **/
@Pipeline(name = DataMappingPipeline.NAME)
public class DataMappingPipeline {
    public final static String NAME = "map";

    /**
     * 开始
     */
    @Phase(order = 1000)
    public final static String START = "start";

//    /**
//     * 数据拉取
//     */
//    @Phase(order = 2000)
//    public final static String EXTRACT = "extract";
//
//    /**
//     * 数据审核
//     */
//    @Phase(order = 3000)
//    public final static String AUDIT = "extract";

    /**
     * 数据映射
     */
    @Phase(order = 2000)
    public final static String MAPPING= "mapping";

    /**
     * 映射后续
     */
    @Phase(order = 3000)
    public final static String ACTION = "action";

    /**
     * 结束End
     * 【1】出参response对象debug日志打印
     */
    @Phase(order = 4000)
    public final static String END = "end";
}
