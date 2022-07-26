package cn.zswltech.preserver.core.rule.rule.detail;

import cn.zswltech.preserver.core.rule.rule.SimpleRule;
import lombok.Data;

/**
 * @author: xinhao.hu
 * @date: 2022/5/16 4:40 下午
 * @description:
 **/
@Data
public class CommonDetail implements IDetail{
    protected SimpleRule simpleRule;
    protected String description;
}
