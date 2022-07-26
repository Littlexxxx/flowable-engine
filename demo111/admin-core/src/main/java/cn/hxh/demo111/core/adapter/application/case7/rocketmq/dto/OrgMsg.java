package cn.hxh.demo111.core.adapter.application.case7.rocketmq.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/6/17 4:42 下午
 * @description:
 **/
@Data
public class OrgMsg {
    private String workAddr;
    private String orgTypeCode;
    private String provinceCode;
    private String provinceName;
    private String fullName;
    private String superiorOrgId;
    private String orgId;
    private String orgTypeName;
    private String shortName;
    private String orgCode;

    /**
     * 转成RiskOrg对应字段的key名
     * @return map
     */
    public Map<String,String> transferKey(){
        Map<String,String> map = new HashMap<>();
        map.put("code",orgCode);
        map.put("simpleName",shortName);
        return map;
    }

}
