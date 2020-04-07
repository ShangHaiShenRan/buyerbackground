package com.hangyiyun.hangyiyun.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author wangcc
 * @Description //TODO token 拦截器 组件之一
 * @Date 23:49 2020/4/3
 * @Param
 * @return
 **/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthToken {

}