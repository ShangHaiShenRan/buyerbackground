package com.hangyiyun.hangyiyun.zlz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.controller.EnterpriseController;
import com.hangyiyun.hangyiyun.controller.TestController;
import com.shsr.objectvo.vo.company.Enterprise;
import com.shsr.objectvo.vo.user.PigcmsUser;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterpriseControllerTest {
    @Autowired
    EnterpriseController enterpriseController;

    @Autowired
    TestController testController;
    private Enterprise enterprise;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void register() {
        enterprise=new Enterprise();
        enterprise.setPhone("18516022025");
        enterprise.setPassword("Zlz13117500158");
        enterprise.setCompanyName("数据测试数据测试4");

        JSONObject register = enterpriseController.register(enterprise);
        System.out.println(register.toString());

        /*
        * 登陆测试
        * */
/*        PigcmsUser pigcmsUser=new PigcmsUser();
        pigcmsUser.setPhone("18516022025");
        pigcmsUser.setPassword("Zlz13117500158");
        JSONObject login = enterpriseController.login(pigcmsUser);
        System.out.println("打印登陆后的内容是:"+login.toString());*/


    }


}