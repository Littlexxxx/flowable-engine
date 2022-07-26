package cn.zswltech.preserver.core.audit;

import cn.zswltech.preserver.core.rule.rule.Rule;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/5/24 5:50 下午
 * @description:
 **/
@Data
@Builder
public class AuditRequest {

    private List<Map<String,Object>> auditData;

    private Rule rule;


}
