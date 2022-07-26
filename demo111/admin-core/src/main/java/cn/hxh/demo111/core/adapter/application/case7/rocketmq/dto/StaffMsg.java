package cn.hxh.demo111.core.adapter.application.case7.rocketmq.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/6/17 4:49 下午
 * @description:
 **/
@Data
public class StaffMsg {
    private int empAge;
    private String posCode;
    private String posName;
    private String empName;
    private String eduBgName;
    private String depName;
    private String depCode;
    private String eduBgCode;
    private String rmpStatusCode;
    private String orgName;
    private String empStatusName;
    private String orgCode;
    private String empId;
    private String empCode;


    /**
     * 转成RiskStaff对应字段的key名
     * @return map
     */
    public Map<String,String> transferStaffKey(){
        Map<String,String> map = new HashMap<>();
        map.put("depCode",depCode);
        map.put("orgCode",orgCode);
        map.put("empCode",empCode);
        map.put("empStatusName",empStatusName);
        map.put("eduBgCode",eduBgCode);
        map.put("posCode",posCode);
        map.put("empName",empName);
        // TODO 待接口扩充后补充
        return map;
    }


    public Map<String,String> transferJobKey(){
        Map<String,String> map = new HashMap<>();
        map.put("name",posName);
        map.put("code",posCode);
        return map;
    }


}
