package com.hangyiyun.hangyiyun.apiresult;

/**
 * @创建人: wangcc
 * @创建时间: 2020/4/18
 * @描述:响应码枚举，参考HTTP状态码的语义
 **/
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    INVALID_SCOPE(403),//登陆但权限缺失
    BAD_REQUEST(405),
    INVALID_PERMISSION(508);//权限错误

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
