package cn.hxh.demo111.core.adapter.application.case7.rocketmq.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/6/17 4:42 下午
 * @description:
 **/
@Data
public class OrgSyncMsg {
    private String type;
    private List<OrgMsg> data;
}
