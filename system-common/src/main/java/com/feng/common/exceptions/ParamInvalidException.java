package com.feng.common.exceptions;

import com.feng.common.enums.ErrorEnum;
import com.feng.common.error.CommonError;

public class ParamInvalidException extends RuntimeException implements CommonError {
    private String msg;
    private int code;

    public ParamInvalidException(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.msg= errorEnum.getMsg();
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

