package com.hangyiyun.hangyiyun.zlz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.apiresult.Result;
import com.hangyiyun.hangyiyun.controller.EnterpriseController;

import com.hangyiyun.hangyiyun.controller.UserController;
import com.shsr.objectvo.hangyiyun.vo.company.Enterprise;
import com.shsr.objectvo.hangyiyun.vo.user.PigcmsUser;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterpriseControllerTest {
    @Autowired
    EnterpriseController enterpriseController;
    @Autowired
    UserController userController;

    private Enterprise enterprise;
    private PigcmsUser pigcmsUser;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void register() throws Exception {


    }


    public void test(){


    }
}