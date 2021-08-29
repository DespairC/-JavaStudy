package com.hwh.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication(scanBasePackages =
        {   "com.hwh.framework",
            "com.hwh.api"
        })
@MapperScan(basePackages = "com.hwh.**.mapper")
//@EnableTransactionManagement
@EnableScheduling
@Configuration
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run (Application.class, args);
    }
}
