package com.hangyiyun.hangyiyun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *@ClassName MemberController
 *@Description TODO
 *@Author lenovo
 *@Date 2020/4/1 12:28
 *
 */

@RestController
@RequestMapping("/Member")
public class MemberController {

    int i =  100;

    final String HOSST ="http://xyyapi.michain.tech";



    /**
     * @Author wangcc
     * @Description //TODO 根据名字验证登陆获得token
     * @Date 13:04 2020/4/1
     * @Param []
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/loginByName",method = RequestMethod.POST)
    public Map<String,Object> loginByName(){
        
        return null;
    }
}
