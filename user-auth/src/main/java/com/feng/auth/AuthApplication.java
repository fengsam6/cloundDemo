package com.feng.auth;

import com.feng.common.auto.EnableMyDruild;
import com.feng.common.auto.EnableMySwagger;
import com.feng.common.util.ApplicationContextInfoUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableMySwagger
@EnableMyDruild
public class AuthApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AuthApplication.class);
        ApplicationContextInfoUtils.printSystemInfo(applicationContext);
    }
}
