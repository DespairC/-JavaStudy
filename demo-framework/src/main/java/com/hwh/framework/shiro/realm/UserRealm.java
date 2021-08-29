package com.hwh.framework.shiro.realm;

import com.hwh.api.mapper.UserMapper;
import com.hwh.common.util.MyStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HwH
 * @date 2021/8/28 14:16
 * @description
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;

    /**
     * 认证,获取身份验证信息
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("---身份认证方法---");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token.getUsername());
        // 从数据库获得对应的用户名密码的用户
        String password = userMapper.getPassword(token.getUsername());
        System.out.println(password);
        if(MyStringUtils.isEmpty(password)){
            throw new AccountException("用户名不正确");
        }
        else if(!password.equals(new String((char[]) token.getCredentials()))){
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());

    }


    /**
     * 授权
     * @param principalCollection 许可
     * @return 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("---权限认证---");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = userMapper.getRole(username);
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        Set<String> set = new HashSet<>();
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);

        return info;
    }

}
