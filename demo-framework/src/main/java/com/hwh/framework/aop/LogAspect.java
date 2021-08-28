package com.hwh.framework.aop;

import com.hwh.common.util.MyStringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;


/**
 * @author HwH
 * @date 2021/8/28 0:30
 * @description 环绕日志
 */
@Aspect
@Component
public class LogAspect {
    /**
     *  注入Logger
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 记录开始时间和结束时间
     */
    private Long startTime;
    private Long endTime;


    /**
     * 环绕前
     * @param joinPoint
     * */
    @Before("execution(* com.hwh.*.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        this.startTime = System.currentTimeMillis();
        //获得请求参数
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //输出日志
        logger.info("开始时间: {}",LocalDateTime.now());
        logger.info("请求URL: {}",request.getRequestURL().toString());
        logger.info("请求方式: {}" , request.getMethod());
        logger.info("请求ip : {}" , request.getRemoteAddr());
        logger.info("请求方法: {}" , joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("请求参数: {}" , Arrays.toString(joinPoint.getArgs()));


    }

    /**
     * 环绕后
     * @param result 获得的返回值
     * */
    @AfterReturning(returning = "result", pointcut = "execution(* com.hwh.*.controller.*.*(..))")
    public void logAfter(Object result){
        this.endTime = System.currentTimeMillis();

        //输出日志
        logger.info("结束时间 : {}" , LocalDateTime.now());
        logger.info("请求耗时 : {}" , (endTime - startTime));
        logger.info("请求返回 : {}" , result.toString());

    }

    /**
     * 异常输出
     * */
    @AfterThrowing(value = "execution(* com.hwh.*.controller.*.*(..))", throwing = "throwable")
    public void logThrowing(Throwable throwable){
        logger.error("发生异常时间：{}" , LocalDateTime.now());
        logger.error("抛出异常：{}" , throwable.getMessage());
    }

}
