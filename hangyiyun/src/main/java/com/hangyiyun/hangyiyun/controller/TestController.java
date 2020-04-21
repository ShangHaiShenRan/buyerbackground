package com.hangyiyun.hangyiyun.controller;

import com.hangyiyun.hangyiyun.apiResult.Result;
import com.hangyiyun.hangyiyun.apiResult.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* docker部署项目测试连接接口
*
* */
@RestController
@RequestMapping("/Test")
public class TestController {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";




    @RequestMapping("/test")
    @ApiOperation(tags="写入测试方法",value="这里写入测试的值")
    public Result<JSONObject> test(){

        JSONObject result = new JSONObject();
        result.put("date","this is demo");

        return ResultGenerator.successResult();
    }
}
