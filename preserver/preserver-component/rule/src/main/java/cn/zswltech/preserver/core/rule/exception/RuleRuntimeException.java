package cn.zswltech.preserver.core.rule.exception;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 2:04 下午
 * @description:
 **/
public class RuleRuntimeException extends RuntimeException{

    public RuleRuntimeException(String msg){
        super(msg);
    }
    public RuleRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
