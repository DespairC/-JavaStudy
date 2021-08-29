package com.hwh.framework.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HwH
 * @date 2021/8/28 19:59
 * @description
 */
public class CoreConfig implements WebMvcConfigurer {
    /**
     * 支持跨域请求
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //设置允许跨域的路径
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOrigins("*")
                //设置允许跨域的方法
                .allowedMethods("GET","POST","PUT","DELETE")
                .allowedHeaders("*")
                //是否允许证书
                .allowCredentials(true)
                //跨域允许时间
                .maxAge(3600);
    }
}
