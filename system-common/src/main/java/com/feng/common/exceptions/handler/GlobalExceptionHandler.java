package com.feng.common.exceptions.handler;

import com.feng.common.entity.ResponseResult;
import com.feng.common.enums.ErrorEnum;
import com.feng.common.exceptions.AppException;
import com.feng.common.exceptions.ParamInvalidException;
import com.feng.common.util.ResponseResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(BindException.class)
    public ResponseResult handleBindException(BindException e) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = e.getFieldError();
        String msg = fieldError.getDefaultMessage();
        logger.error(msg);
        e.printStackTrace();
        // 生成返回结果
        return ResponseResultUtil.renderError(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(e.getMessage()));
    }

    @ExceptionHandler(ParamInvalidException.class)
    public ResponseResult paramInvalidExceptionHandler(ParamInvalidException e) {
        e.printStackTrace();
        return ResponseResultUtil.renderError(e);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseResult IllegalArgumentExceptionHandler(IllegalArgumentException e) {
        e.printStackTrace();
        return ResponseResultUtil.renderError(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        return ResponseResultUtil.renderError(ErrorEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(e.getMessage()));
    }

    @ExceptionHandler(AppException.class)
    public ResponseResult businessExceptionHandler(AppException e) {
        e.printStackTrace();
        return ResponseResultUtil.renderError(e);
    }



    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e, HttpServletRequest request) {
        logger.error("----------{}---- ----",e.getMessage());
        if (e instanceof NoHandlerFoundException) {
            String errorMsg = String.format("请求url %s不存在！",request.getRequestURI());
            logger.error(errorMsg);
            return ResponseResultUtil.renderError(ErrorEnum.PAGE_NOT_FOUND.setMsg(errorMsg));
        }
        e.printStackTrace();
        return ResponseResultUtil.renderError(ErrorEnum.UN_KNOW_EXCEPTION);
    }
}
