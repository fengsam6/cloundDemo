package com.feng.user;

import com.feng.common.auto.EnableMyDruild;
import com.feng.common.auto.EnableMySwagger;
import com.feng.common.util.ApplicationContextInfoUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author feng
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value="com.feng.user.dao")
@EnableMySwagger
@EnableMyDruild
public class UserApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserApplication.class, args);
        ApplicationContextInfoUtils.printSystemInfo(context);
    }

}
