package com.feng;

import com.feng.systemGenerator.gen.Generator;

public class GenCode {
    public static void main(String[] args) {
        //指定包名
        String packageName = "com.feng.secKill";
        //user -> UserService, 设置成true: user -> IUserService
        boolean serviceNameStartWithI = false;
        //指定生成的表名
        String[] tableNames = new String[]{"sk_goods_seckill"};
        Generator generator = new Generator();
        generator.generateByTables(serviceNameStartWithI, packageName, tableNames);
    }
}
