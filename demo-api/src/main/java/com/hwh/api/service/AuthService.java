package com.hwh.api.service;

import com.hwh.common.domain.dto.Result;

/**
 * @author HwH
 * @date 2021/8/28 19:08
 * @description 登录服务
 */

public interface AuthService {
    /**
     * 登录
     * @param username 用户名
     * @return 登录状态
     * */
     Result login(String username, String password);

     /**
      * 注销
      * */
     Result loginOut();

     /**
      * find
      * */
     Result find();
}
