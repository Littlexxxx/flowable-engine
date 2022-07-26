package cn.hxh.demo111.core.adapter.application.case7.rocketmq;

import org.springframework.stereotype.Component;

/**
 * @author: xinhao.hu
 * @date: 2022/7/1 5:10 下午
 * @description:
 **/
@Component
public class RiskInfoConsumer1 extends RiskInfoConsumer{
    @Override
    public String getTopic() {
        return "zjjt_organization_notify_message";
    }

    @Override
    public void executeMsg(String result) {
        System.out.println(1+" "+result);
    }

    @Override
    public String getGroup() {
        return "sync_group_2";
    }
}
