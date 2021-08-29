package com.hwh.api.controller;

import com.hwh.api.mapper.UserMapper;
import com.hwh.api.service.AuthService;
import com.hwh.api.service.impl.AuthServiceImpl;
import com.hwh.common.domain.dto.Result;
import com.hwh.common.domain.enums.CodeEnum;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author HwH
 * @date 2021/8/28 10:37
 * @description 登录接口
 */
@RestController
public class LoginController {
    private UserMapper userMapper;

    private AuthService authService;

    @Autowired
    public LoginController(AuthServiceImpl authService) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/notLogin")
    public Result notLogin(){
        return Result.success(CodeEnum.SUCCESS,"您尚未登陆!");
    }

    @GetMapping("/notRole")
    public Result notRole(){
        return Result.success(CodeEnum.SUCCESS,"您没有权限！");
    }

    @GetMapping("/logout")
    public Result logout(){
        return authService.loginOut();
    }

    @PostMapping("/login")
    public Result login(@Param("username") String username,@Param("password") String password){
        return authService.login(username, password);
    }

    @GetMapping("/find")
    public Result find(){
        return authService.find();
    }

}
