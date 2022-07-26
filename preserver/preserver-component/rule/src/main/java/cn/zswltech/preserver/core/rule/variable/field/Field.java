package cn.zswltech.preserver.core.rule.variable.field;

import cn.zswltech.preserver.core.rule.context.RuleExecuteContext;
import cn.zswltech.preserver.core.rule.exception.ParseException;
import cn.zswltech.preserver.core.rule.rule.detail.DetailCallable;
import cn.zswltech.preserver.core.rule.rule.detail.FieldDetail;
import cn.zswltech.preserver.core.rule.utils.DataConvertUtils;
import cn.zswltech.preserver.core.rule.variable.Variable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: xinhao.hu
 * @date: 2022/5/12 3:15 下午
 * @description:
 **/
@Data
@NoArgsConstructor
public class Field implements Variable {
    private String name;

    private String dataType;


    public Field(String name, String dataType) {
        if (StringUtils.isBlank(name)) {
            throw new ParseException("field name can't be blank!");
        }
        this.name = name;
        this.dataType = dataType;
        if (StringUtils.isNotBlank(this.dataType)) {
            this.dataType = this.dataType.toLowerCase();
        }

    }

    @Override
    public Object eval(RuleExecuteContext executeContext) {
        Object ret = executeContext.getField(name);
        if (null == ret) {
            return null;
        }
        return DataConvertUtils.convertByType(ret, dataType);
    }

    @Override
    public String getType() {
        return "field";
    }

    @Override
    public DetailCallable getDetail(Object value) {
        FieldDetail detail = new FieldDetail();
        detail.setName(this.name);
        detail.setValue(value);
        detail.setDataType(dataType);
        return () -> detail;
    }
}
