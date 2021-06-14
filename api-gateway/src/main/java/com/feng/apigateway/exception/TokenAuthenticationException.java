package com.feng.apigateway.exception;

import com.feng.common.enums.ErrorEnum;
import com.feng.common.exceptions.AppException;

import static com.feng.common.enums.ErrorEnum.TOKEN_INVALIDATE;

public class TokenAuthenticationException extends AppException {
    public TokenAuthenticationException( String msg) {
        this(TOKEN_INVALIDATE.setMsg(msg));
    }

    public TokenAuthenticationException(ErrorEnum errorEnum) {
        super(errorEnum);
    }
}
