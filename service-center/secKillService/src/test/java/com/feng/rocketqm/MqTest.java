package com.feng.rocketqm;

import com.feng.secKill.GoodsSecKillApplication;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = GoodsSecKillApplication.class)
@RunWith(SpringRunner.class)

public class MqTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendTest() {
        rocketMQTemplate.convertAndSend("order", "a good is coming");
    }

    @Component
    @RocketMQMessageListener(topic = "order", consumerGroup = "seckill")
    public static class Reciver implements RocketMQListener<String> {

        @Override
        public void onMessage(String msg) {
            System.out.print(msg);
        }
    }
}
