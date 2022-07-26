package cn.hxh.demo111.core.adapter.application.case7.rocketmq;


import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
public abstract class RiskInfoConsumer {

    @Value("${risk.info.consumer.server.address}")
    private String serverAddress;

    private String topic;

    @Value("${risk.info.consumer.charset}")
    private String charset;

    private String group;

    @PostConstruct
    public void init(){
        try{
            //1.创建消费者Consumer，制定消费者组名
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(getGroup());
            //2.指定Nameserver地址
            consumer.setNamesrvAddr(serverAddress);
            //消息拉取最大条数
            consumer.setConsumeMessageBatchMaxSize(2);
            //3.订阅主题Topic和Tag
            consumer.subscribe(getTopic(), "*");
            //4.设置回调函数，处理消息
            consumer.registerMessageListener(new MessageListenerOrderly() {
                //接受消息内容
                @Override
                public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext consumeOrderlyContext) {
                    for (MessageExt msg : msgs) {
                        try {
                            //获取标签
                            String tags = msg.getTags();
                            //获取信息
                            byte[] body =  msg.getBody();
                            String result = new String(body, charset);
                            // 处理消息
                            executeMsg(result);
                        } catch (UnsupportedEncodingException e) {
                            log.warn(""); //TODO
                            //重试
                            return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                        }
                    }
                    return ConsumeOrderlyStatus.SUCCESS;
                }
            });
            //5.启动消费者consumer
            consumer.start();
        }catch (MQClientException e) {
            log.error("",e);
        }
    }

    public abstract String getTopic();

    public abstract void executeMsg(String result);

    public abstract String getGroup();
}