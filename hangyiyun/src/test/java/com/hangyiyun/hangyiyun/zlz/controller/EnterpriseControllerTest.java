package com.hangyiyun.hangyiyun.zlz.controller;


import com.hangyiyun.hangyiyun.zlz.entity.Enterprise;
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
    private Enterprise enterprise;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void register() {
//        enterprise=new Enterprise();
//        enterprise.setPhone("18516022025");
//        enterprise.setPassword("Zlz13117500158");
//        enterprise.setCompanyName("数据测试数据测试4");
//
//        String register = enterpriseController.register(enterprise);
//        System.out.println(register);

        /*
        * 登陆测试
        * */
        PigcmsUser pigcmsUser=new PigcmsUser();
        pigcmsUser.setPhone("18516022025");
        pigcmsUser.setPassword("Zlz13117500158");
        String login = enterpriseController.login(pigcmsUser);

    }


}