package cn.zswltech.preserver.core.binlog.monitor.exception;

/**
 * @author: xinhao.hu
 * @date: 2022/5/20 4:20 下午
 * @description:
 **/
public class BinlogMonitorRuntimeException extends RuntimeException{
    public BinlogMonitorRuntimeException(String msg,Throwable e){
        super(msg,e);
    }

    public BinlogMonitorRuntimeException(String msg){
        super(msg);
    }

    public BinlogMonitorRuntimeException(Throwable e){
        super(e);
    }
}
