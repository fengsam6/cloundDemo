package com.feng.registercenter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterApplication {
    private static Logger logger = LoggerFactory.getLogger(RegisterCenterApplication.class);
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(RegisterCenterApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String eurekaUrl = environment.getProperty("eureka.client.service-url.defaultZone");
        if (!StringUtils.isEmpty(eurekaUrl)) {
            int i=-1;
            if((i=eurekaUrl.lastIndexOf("/eureka"))>0){
                eurekaUrl = eurekaUrl.substring(0,i);
            }
            System.out.printf(">>>>>>>>>>>>>>>>>>>>>>注册中心地址：%s >>>>>>>>>>\n",eurekaUrl);
        }
    }

}
