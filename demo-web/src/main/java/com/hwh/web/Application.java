package com.hwh.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author HwH
 * @date 2021/8/28 0:25
 * @description
 */
@SpringBootApplication(scanBasePackages =
        {
                "com.hwh.framework",
                "com.hwh.api",
                "com.hwh.common"
        })
//@MapperScan(basePackages = "com.lce.**.mapper")
//@EnableTransactionManagement
@EnableScheduling
@Configuration
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run (Application.class, args);
    }
}