package com.feng.common.entity;


/**
 * Created by rf
 */
public class ResponseResult<T> {
    public static final int SUCCESS_CODE = 200;
    private int code;
    private String message;
    private T data;

    public ResponseResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public  ResponseResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public static <T> ResponseResult<T> success(T data, String msg) {
        ResponseResult<T> tResponseResult = new ResponseResult<>(data, msg);
        tResponseResult.code =SUCCESS_CODE;
        return tResponseResult;
    }

    public static ResponseResult success(String msg) {
        return success(null, msg);
    }

    public static ResponseResult success() {
        return success("操作成功！");
    }

    public static ResponseResult fail(int code, String msg) {
        return new ResponseResult<>(code, msg);
    }

    public static ResponseResult fail(String msg) {
        return fail(500, msg);
    }

    public static ResponseResult fail() {
        return fail("操作失败");
    }
}

