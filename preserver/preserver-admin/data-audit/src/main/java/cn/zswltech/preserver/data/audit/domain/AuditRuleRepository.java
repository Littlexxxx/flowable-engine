package cn.zswltech.preserver.data.audit.domain;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/5/26 10:01 上午
 * @description:
 **/
public interface AuditRuleRepository {

    List<AuditRule> queryAll();
}
