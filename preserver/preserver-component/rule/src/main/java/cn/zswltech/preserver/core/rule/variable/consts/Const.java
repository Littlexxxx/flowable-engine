package cn.zswltech.preserver.core.rule.variable.consts;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.rule.detail.ConstDetail;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;
import cn.zswltech.preserver.core.rule.utils.DataConvertUtils;
import cn.zswltech.preserver.core.rule.variable.Variable;
import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 10:35 上午
 * @description:
 **/
@Data
public class Const implements Variable {
    private String consts;
    private String dataType;

    @Override
    public Object eval(RuleExecuteContext executeContext) {
        if (null == consts) {
            return null;
        }
        return DataConvertUtils.convertByType(consts, dataType);
    }

    @Override
    public String getType() {
        return "const";
    }

    @Override
    public DetailCallable getDetail(Object value) {
        ConstDetail detail = new ConstDetail();
        detail.setConsts(consts);
        detail.setDataType(dataType);
        return () -> detail;
    }
}
