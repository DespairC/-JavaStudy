package com.hwh.common.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hwh.common.domain.enums.CodeEnum;

import java.io.Serializable;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    /**
     * 成功响应（有数据）
     * @param codeEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success (CodeEnum codeEnum, T data){
        return new Result<T>(codeEnum, data);
    }

    public static <T> Result<T> success (Integer code, String msg, T data){
        return new Result<T>(code, msg, data);
    }

    /**
     * 成功响应（无数据）
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> Result<T> success (CodeEnum codeEnum){
        return new Result<T>(codeEnum);
    }

    /**
     * 错误响应
     * @param codeEnum
     * @param <T>
     * @return
     */
    public static <T> Result<T> error (CodeEnum codeEnum){
        return new Result<>(codeEnum);
    }

    public static <T> Result<T> error (CodeEnum codeEnum, T data){
        return new Result<>(codeEnum, data);
    }

    public static <T> Result<T> error (Integer code, String msg){
        return new Result<>(code,msg);
    }

    public Result(CodeEnum codeEnum){
        this.code = codeEnum.getCode();
        this.msg =codeEnum.getMsg();
    }

    public Result(CodeEnum codeEnum, T data){
        this(codeEnum);
        this.data = data;
    }

    public Result(Integer code, String msg){
        this.code = code;
        this.msg =msg;
    }

    public Result(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(){ }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
