package com.hwh.api.mapper;

import com.hwh.common.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author HwH
 * @date 2021/8/28 14:23
 * @description
 */

@Repository
public interface UserMapper {

    /**
     *
     * */
    List<User> getAll();

    /**
     * 查询密码
     * */
    String getPassword(@Param("username") String username);
    /**
     * 获得对应权限
     * */
    String getRole(@Param("username") String username);
}
