package com.hwh.common.exception;


import com.hwh.common.domain.enums.CodeEnum;

/**
 * @author Red Date.
 * @Description 自定义抛出的异常类
 * @date 2020/10/14 18:36
 */
public class ErrorException extends RuntimeException{
    private static final long serialVersionUID = -7864604160297181941L;

    private final int code;


    /**
     * 自己定义错误码和错误信息
     * @param code
     * @param message
     */
    public ErrorException(final int code, final String message) {
        super(message);
        this.code = code;
    }
    public ErrorException(final CodeEnum codeEnum, final String message) {
        super(message);
        this.code = codeEnum.getCode();
    }

    public ErrorException(final CodeEnum exceptionCode) {
        super(exceptionCode.getMsg());
        this.code = exceptionCode.getCode();
    }

    public int getCode() {
        return code;
    }
}
