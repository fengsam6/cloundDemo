package com.feng.common.exceptions;

import com.feng.common.enums.ErrorEnum;
import com.feng.common.error.CommonError;

public class AppException extends RuntimeException implements CommonError {
    private int code;
    private String msg;

    public AppException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public AppException(ErrorEnum errorEnum) {
        this(errorEnum.getCode(), errorEnum.getMsg());
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}