package com.hangyiyun.hangyiyun.apiResult;

import com.alibaba.fastjson.JSON;

/**
 * @创建者: wangcc
 * 统一API响应结果封装
 */
public class ResultTemplate<T> {

    private int code;
    private String message;
    private T data;

    public ResultTemplate setCode(ResultCode resultCode) {
        this.code = resultCode.code();
        return this;
    }

    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    public ResultTemplate setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultTemplate setData(T data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
