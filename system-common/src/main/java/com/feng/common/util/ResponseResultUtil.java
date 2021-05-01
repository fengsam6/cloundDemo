package com.feng.common.util;

import com.feng.common.entity.ResponseResult;
import com.feng.common.error.CommonError;

public class ResponseResultUtil {
    public static<T> ResponseResult<T> renderSuccess(T data) {
        return renderSuccess( data,"操作成功");
    }

    public static ResponseResult renderSuccessMsg(String msg) {
        return new ResponseResult(200, msg);
    }

    public static <T> ResponseResult<T> renderSuccess(T data,String msg) {
        return ResponseResult.success(data, msg);
    }

    public static ResponseResult renderError(int code, String msg) {
        return new ResponseResult(code, msg);
    }

    public static ResponseResult renderError(CommonError commonError) {
        return renderError(commonError.getCode(), commonError.getMsg());
    }

}
