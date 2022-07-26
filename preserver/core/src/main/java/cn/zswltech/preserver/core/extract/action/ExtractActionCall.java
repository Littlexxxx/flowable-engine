package cn.zswltech.preserver.core.extract.action;

import cn.zswltech.preserver.core.extract.context.ExtractContext;
import cn.zswltech.preserver.core.extract.context.ExtractResponse;

/**
 * @author: xinhao.hu
 * @date: 2022/5/25 4:32 下午
 * @description: 拉取数据后续处理
 **/
public interface ExtractActionCall {
    void call(ExtractContext context,ExtractResponse response);

    String getName();
}
