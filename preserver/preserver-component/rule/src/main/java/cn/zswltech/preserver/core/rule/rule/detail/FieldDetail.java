package cn.zswltech.preserver.core.rule.rule.detail;

import lombok.Data;

@Data
public class FieldDetail extends CommonDetail {

    String name;

    String dataType;

    Object value;

}