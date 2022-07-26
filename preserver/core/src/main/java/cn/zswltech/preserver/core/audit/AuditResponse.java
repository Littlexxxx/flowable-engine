package cn.zswltech.preserver.core.audit;

import cn.zswltech.preserver.core.rule.rule.RuleResult;
import lombok.Data;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/24 5:49 下午
 * @description:
 **/
@Data
public class AuditResponse {

    private List<RuleResult> rejectData = Lists.newArrayList();

    private List<RuleResult> acceptData = Lists.newArrayList();
}
