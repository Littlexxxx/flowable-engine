package cn.hxh.demo111.core.adapter.application.logrecord;

import cn.zswltech.lib.futurelog.core.LogRecord;
import cn.zswltech.lib.futurelog.core.common.OperTypeEnum;
import cn.zswltech.lib.futurelog.core.exception.LogRuntimeException;
import cn.zswltech.lib.futurelog.core.save.LogRecordSave;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xinhao.hu
 * @date: 2022/4/6 3:42 下午
 * @description:
 **/
@Component
public class LogTestService {

    @LogRecord(model = "test",
            success = "test success!",
            fail = "test fail!",
            operType = OperTypeEnum.ADD)
    public void testSuccess(String name, String str) {
        System.out.println("test success");
    }

    @LogRecord(model = "test",
            success = "test success!",
            fail = "test fail!",
            operType = OperTypeEnum.ADD)
    public void testFail(String name, String str) {
        throw new LogRuntimeException("test");
    }

    @LogRecord(model = "test",
            success = "test condition",
            condition = "{'str'.equals('str')}",
            operType = OperTypeEnum.ADD)
    public void testCondition(String name, String str){
        System.out.println("test condition");
    }

    @LogRecord(model = "test",
            success = "test spel: {#name}+{#str.toString()}",
            operType = OperTypeEnum.ADD)
    public void testSpel(String name, String str){
        System.out.println("test spel");
    }

    @LogRecord(model = "test",
            success = "test function: {#name}+{getName{#str}}",
            operType = OperTypeEnum.ADD)
    public void testFunction(String name, LogRecordSave str){
        System.out.println("test function");
    }

}
