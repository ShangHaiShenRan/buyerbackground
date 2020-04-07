package com.hangyiyun.hangyiyun.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.annotation.AuthToken;
import com.hangyiyun.hangyiyun.controller.UserController;
import com.hangyiyun.hangyiyun.utils.ConstantKit;

import com.hangyiyun.hangyiyun.utils.RedisUtil;
import com.hangyiyun.hangyiyun.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @Author wangcc
 * @Description //TODO 拦截器，验证前端Token  方法：要验证的类上添加@AuthToken
 * @Date 23:17 2020/4/3
 * @Param 
 * @return 
 **/
@Slf4j
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private RedisUtil redisUtil;

    //存放鉴权信息的Header名称，默认是Authorization
    private String httpHeaderName = "Authorization";

    //鉴权失败后返回的错误信息，默认为401 unauthorized
    private String unauthorizedErrorMessage = "401 unauthorized";

    //鉴权失败后返回的HTTP错误码，默认为401
    private int unauthorizedErrorCode = HttpServletResponse.SC_UNAUTHORIZED;

    /**
     * 存放验证用户成功的Token TOKEN_FOR_LOGIN
     */
    public static final String TOKEN_FOR_LOGIN = "TOKEN_FOR_LOGIN";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("-------------------------------");
        Boolean result = true;
        String token = "";

        if (!(handler instanceof HandlerMethod)) {
            result = true;
        }else{

            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();

            /*设置编码格式*/
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");


            // 如果打上了AuthToken注解则需要验证token
            if (method.getAnnotation(AuthToken.class) != null || handlerMethod.getBeanType().getAnnotation(AuthToken.class) != null) {

                //从请求头中找到token
                token = request.getHeader(httpHeaderName);

                PrintWriter pw = response.getWriter();
                JSONObject resultMsg = new JSONObject();

                log.info("第一次打印token:"+token.toString());
                /*拿到的token非空， 如果空返回消息给前端*/
                if (!StringUtils.isNotBlank(token)) {
                    resultMsg.put("message", "权限不足，未检测到token");
                    resultMsg.put("status", "false");
                    log.error("未检测到token");
                    pw.write(resultMsg.toString());
                    result = false;
                } else {
                    log.info("打印token是：:"+token.toString());
                    /*获得token后 直接去redis验证是否存在*/
                    boolean hasToken = redisUtil.hasKey(token);

                    if (hasToken) {
                        log.info("token 验证成功！");
                        result = true;
                    }else {
                        log.error("token 验证失败！");
                        resultMsg.put("message", "权限不足，传入的token以失效");
                        resultMsg.put("status", "false");
                        pw.write(resultMsg.toString());
                        result = false;
                    }
                }
                pw.flush();
                pw.close();
            }
        }
        return result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
