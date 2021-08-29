package com.hwh.common.util;

import org.springframework.lang.Nullable;

/**
 * @author HwH
 * @date 2021/8/28 9:06
 * @description 字符串对比工具
 */
public class MyStringUtils {


    /**
     * 判断为空
     * */
    public static boolean isEmpty(@Nullable Object str){
        return str == null;
    }

    /**
     * 拼接字符串
     * */
    public static String append(String... str){
        StringBuilder result = new StringBuilder();
        for (String s:str) {
            result.append(s);
        }
        return result.toString();
    }


}
