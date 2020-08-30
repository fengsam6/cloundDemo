package com.feng.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

public class ApplicationContextInfoUtils {
    private static Logger logger = LoggerFactory.getLogger(ApplicationContextInfoUtils.class);
    public static void printSystemInfo(ApplicationContext applicationContext) {
        Environment environment = applicationContext.getEnvironment();
        String port = environment.getProperty("server.port");
        String appName = environment.getProperty("spring.application.name");
        String contextPath = environment.getProperty("server.servlet.context-path");
        if(contextPath==null){
            contextPath="";
        }
        printRegisterInfo(environment);
        String ip = "localhost";
        String indexUrl = "http://"+ip+":"+port+contextPath;
        System.out.printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+appName+"首页url：%s>>>>>>>>>>>>>>>>>>>>>>\n",indexUrl);
        System.out.printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  后端swagger接口文档url：%s>>>>>>>>>>>>>>>>>>>>>\n",indexUrl+"/swagger-ui.html");
        System.out.printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 后端 druid 监控中心url：%s,用户名 admin，密码 admin>>>>>>>>>>>>>>>>>>>\n",indexUrl+"/druid");

    }

    /**
     * 打印注册中心信息
     * @param environment
     */
    public static void printRegisterInfo(Environment environment){
        String eurekaUrl = environment.getProperty("eureka.client.service-url.defaultZone");
        if(!StringUtils.isEmpty(eurekaUrl)){
            int i=-1;
            if((i=eurekaUrl.lastIndexOf("/eureka"))>0){
                eurekaUrl = eurekaUrl.substring(0,i);
            }
            System.out.printf(">>>>>>>>>>>>>>>>>>>>>>>>>>>  注册中心地址：%s >>>>>>>>>>>>>>>\n",eurekaUrl);
        }
    }
}

