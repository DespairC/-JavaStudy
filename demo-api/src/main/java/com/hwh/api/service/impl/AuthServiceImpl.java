package com.hwh.api.service.impl;

import com.hwh.api.mapper.UserMapper;
import com.hwh.api.service.AuthService;
import com.hwh.common.domain.dto.Result;
import com.hwh.common.domain.enums.CodeEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HwH
 * @date 2021/8/28 19:08
 * @description
 */
@Service
public class AuthServiceImpl implements AuthService {


    private UserMapper userMapper;

    @Autowired
    public AuthServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result login(String username, String password) {
        // 从 SecurityUtils 创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //执行登录认证
        subject.login(token);
        //根据权限，指定返回数据
        String role = userMapper.getRole(token.getUsername());
        if("user".equals(role)){
            return Result.success(CodeEnum.SUCCESS,"登陆成功");
        }
        if("admin".equals(role)){
            return Result.success(CodeEnum.SUCCESS,"欢迎管理员先生");
        }
        return Result.success(CodeEnum.FAILED_PERMISSION,"权限错误！！");
    }

    @Override
    public Result loginOut() {
        //获得 subject 对象
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        return Result.success(CodeEnum.SUCCESS,"成功注销");
    }

    @Override
    public Result find() {
        System.out.println(userMapper.getPassword("admin"));
        return Result.success(CodeEnum.SUCCESS,userMapper.getPassword("admin"));
    }

}
