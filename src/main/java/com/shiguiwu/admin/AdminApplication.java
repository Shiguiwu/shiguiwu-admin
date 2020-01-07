package com.shiguiwu.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description: 启动类
 * @author: stone
 * @date: Created by 2020/1/5 20:55
 * @version: 1.0.0
 * @pakeage: com.shiguiwu.admin
 */
@SpringBootApplication
@MapperScan(basePackages = "com.shiguiwu.admin.mapper")
public class AdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
