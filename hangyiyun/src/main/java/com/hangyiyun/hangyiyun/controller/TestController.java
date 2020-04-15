package com.hangyiyun.hangyiyun.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* docker部署项目测试连接接口
*
* */
@RestController
@RequestMapping("/Test")
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "测试成功----------";
    }
}
