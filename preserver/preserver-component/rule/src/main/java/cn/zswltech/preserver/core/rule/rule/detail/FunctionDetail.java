package cn.zswltech.preserver.core.rule.rule.detail;

import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 3:40 下午
 * @description:
 **/
@Data
public class FunctionDetail extends CommonDetail {
    protected String functionExpression;
    protected Object value;

}
