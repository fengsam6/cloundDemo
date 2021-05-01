package com.feng.goods;

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
@MapperScan(basePackages = "com.feng.goods.dao")
public class GoodsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(GoodsApplication.class, args);
        ApplicationContextInfoUtils.printSystemInfo(applicationContext);
}

}
