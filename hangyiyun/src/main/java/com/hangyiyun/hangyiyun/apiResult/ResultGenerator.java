package com.hangyiyun.hangyiyun.apiResult;

/**
 * @创建人: wangcc
 * @创建时间: 2020/4/18
 * @描述:响应结果生成工具
 **/
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static ResultTemplate successResult() {
        return new ResultTemplate()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> ResultTemplate<T> successResult(T data) {
        return new ResultTemplate()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static ResultTemplate failResult(String message) {
        return new ResultTemplate()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
}
