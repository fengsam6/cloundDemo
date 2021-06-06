package com.feng.secKill;

import com.feng.common.auto.EnableMyDruild;
import com.feng.common.auto.EnableMySwagger;
import com.feng.common.util.ApplicationContextInfoUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableDiscoveryClient
@EnableFeignClients
@EnableMySwagger
@EnableMyDruild
@SpringBootApplication
@MapperScan(basePackages = "com.feng.secKill")
public class GoodsSecKillApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GoodsSecKillApplication.class, args);
        ApplicationContextInfoUtils.printSystemInfo(applicationContext);
}

}
