package cn.hxh.demo111.core.adapter.application.logrecord;

import cn.zswltech.lib.futurelog.core.function.IFunctionExtend;
import org.springframework.stereotype.Component;

/**
 * @author: xinhao.hu
 * @date: 2022/4/11 9:53 上午
 * @description:
 **/
@Component
public class FunctionGet implements IFunctionExtend {
    @Override
    public String functionName() {
        return "getName";
    }

    @Override
    public String apply(Object input) {
        return input.toString();
    }
}
