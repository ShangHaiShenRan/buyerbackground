package com.hangyiyun.hangyiyun.apiResult;

import com.hangyiyun.hangyiyun.apiResult.Result;
import com.hangyiyun.hangyiyun.apiResult.ResultCode;

/**
 * @创建人: wangcc
 * @创建时间: 2020/4/18
 * @描述:响应结果生成工具
 **/
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result successResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> successResult(T data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result failResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
