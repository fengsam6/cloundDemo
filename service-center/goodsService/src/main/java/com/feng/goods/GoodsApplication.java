package com.feng.goods;

import com.feng.common.auto.EnableMyDruild;
import com.feng.common.auto.EnableMySwagger;
import com.feng.common.util.ApplicationContextInfoUtils;
import com.sun.javaws.security.AppContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableEurekaClient
//@RibbonClient
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
