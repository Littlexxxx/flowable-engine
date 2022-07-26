package cn.hxh.demo111.core.adapter.application.logrecord;

import cn.zswltech.lib.futurelog.core.operator.IOperatorService;
import org.springframework.stereotype.Component;

/**
 * @author: xinhao.hu
 * @date: 2022/4/11 9:51 上午
 * @description:
 **/
@Component
public class OperatorGet implements IOperatorService {
    @Override
    public String getUserName() {
        return "123456";
    }
}
