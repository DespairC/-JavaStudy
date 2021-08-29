package com.hwh.common.domain.enums;

/**
 * @author HwH
 * @date 2021/8/28 11:09
 * @description
 */
public enum CodeEnum {
    // 2xx
    SUCCESS(200,"OK（请求成功）"),

    // 4xx
    BAD_REQUEST(400,"BAD REQUEST（错误请求）"),
    FORBIDDEN(403,"Forbidden（禁止访问）"),
    NOT_FOUND(404,"NOT FOUND（资源未找到）"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    UNKNOWN_ERROR(406,"发生未知错误"),

    // 5xx
    INTERNAL_SERVER_ERROR(500,"Internal Server Error（服务器出错）"),

    // 参数错误
    NULL_PARAM(10001,"参数不能为空"),
    PARAM_PATTERN_INVALID(10002,"参数格式错误"),
    PARAM_NOT_IDEAL(10003,"未查找到信息"),
    FILE_NOT_SUPPORT(10004,"文件格式错误"),
    FILE_UPLOAD_FAIL(10005,"文件上传失败"),
    CANT_NOT_CONVERT_PARAM(10006,"类型转化失败"),

    //登录异常
    LOGIN_VERIFY_CODE_NOT_CORRECT(10007,"验证码错误"),

    //资产查询平台调用异常
    FAILED_CONVERT_PLATFORM_RESULT(10008,"资产查询平台调用异常，请联系后端"),

    // token令牌异常
    FAILED_SIGNATURE(10009,"token签名不一致"),
    TOKEN_EXPIRED(10010,"token过期"),
    ALGORITHM_MISMATCH(10011,"算法不匹配异常"),
    INVALID_CLAIM(10012,"playload失效"),
    EMPTY_TOKEN(10013,"令牌为空"),

    //json转化失败
    JSON_CONVERY_FAILED(10014,"JSON转化失败"),

    // 权限异常
    FAILED_PERMISSION(10015,"权限异常");


    /**
     * 状态码
     */
    private int code;

    /**
     * 响应信息
     */
    private String msg;

    CodeEnum(int code, String msg){
        this.code = code;
        this.msg =msg;
    }

    CodeEnum(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
