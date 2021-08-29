package com.hwh.common.util;


import java.util.Collection;

/**
 * @Description : 判空工具类
 * @Author : Red Date
 * @Date : 2020-01-29
 */
public class VerifyUtil {

    /**
     * 判断字符串是否为空
     * @param string 字符串
     * @return 空返回true
     */
    public static boolean isEmpty(String string){
        return  (null == string  || "".equals(string) || string.trim().isEmpty());
    }
    public static boolean isNotBlank(String string){
        return  !isEmpty(string);
    }

    /**
     * 判断对象是否为空
     * @param object 对象
     * @return 空返回true
     */
    public static boolean isNull(Object object){
        return null == object;
    }
    public static boolean isNotBlank(Object object){
        return !isNull(object);
    }

    /**
     * 判断集合是否为空
     * @param collection 集合
     * @return 空返回true
     */
    public static boolean isEmpty(Collection<?> collection){
        return  (null == collection || collection.size() == 0);
    }
    public static boolean isNotBlank(Collection<?> collection){
        return !isEmpty(collection);
    }

    /**
     * 判断数字是否为空
     * @param integer 数字
     * @return 空返回true
     */
    public static boolean isEmpty(Integer integer) {
        return (null == integer);
    }
    public static boolean isNotBlank(Integer integer){
        return !isEmpty(integer);
    }
}
