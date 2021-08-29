package com.hwh.api.controller;

import com.hwh.api.mapper.UserMapper;
import com.hwh.common.domain.User;
import com.hwh.common.domain.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HwH
 * @date 2021/8/28 9:14
 * @description
 */
@RestController
public class TestController {

    private UserMapper userMapper;

    @Autowired
    public TestController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/test")
    public String test(){
        return "hello world!";
    }

    @GetMapping("/findout")
    public String findout(){
        return userMapper.getPassword("admin");
    }
}
