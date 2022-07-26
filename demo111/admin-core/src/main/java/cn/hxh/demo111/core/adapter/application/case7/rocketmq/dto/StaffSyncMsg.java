package cn.hxh.demo111.core.adapter.application.case7.rocketmq.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: xinhao.hu
 * @date: 2022/6/17 5:03 下午
 * @description:
 **/
@Data
public class StaffSyncMsg {
    private String type;
    private List<StaffMsg> data;
}
