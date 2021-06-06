package com.feng.secKill.mqHandler;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic ="order",consumerGroup = "seckill")
public class OrderHandlerService implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.print("msg :"+s);
    }
}
