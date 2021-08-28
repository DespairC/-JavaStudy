package com.hwh.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HwH
 * @date 2021/8/28 9:14
 * @description
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "hello world!";
    }

}
