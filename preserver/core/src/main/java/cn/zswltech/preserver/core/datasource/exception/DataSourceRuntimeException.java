package cn.zswltech.preserver.core.datasource.exception;

/**
 * @author: xinhao.hu
 * @date: 2022/5/17 6:04 下午
 * @description:
 **/
public class DataSourceRuntimeException extends RuntimeException{

    public DataSourceRuntimeException(String msg,Throwable cause){
        super(msg,cause);
    }

    public DataSourceRuntimeException(String msg){
        super(msg);
    }
}
