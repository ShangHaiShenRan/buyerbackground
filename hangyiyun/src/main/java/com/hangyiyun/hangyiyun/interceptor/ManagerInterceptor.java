package com.hangyiyun.hangyiyun.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *拦截器管理，将拦截器进行配置管理
 * @Param：
 * @Author: Wangcc
 * @Date: 2020/4/6 17:52
 */
@Configuration
public class ManagerInterceptor extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // addPathPatterns 用于添加拦截规则
        registry.addInterceptor(new AuthorizationInterceptor()).addPathPatterns("/**");

        super.addInterceptors(registry);
    }

}
