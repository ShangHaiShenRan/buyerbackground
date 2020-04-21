package com.hangyiyun.hangyiyun.zlz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.controller.EnterpriseController;
import com.hangyiyun.hangyiyun.controller.TestController;

import com.shsr.objectvo.hangyiyun.vo.company.Enterprise;
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
        enterprise.setPhone("18516022033");
        enterprise.setPassword("Zlz13117500158");
        enterprise.setCompanyName("This is Test Data:数据测试数据测试9");

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


    public void test(){
        Map<String,String> a = new HashMap<String,String>();

        JSONObject b = new JSONObject();

        a.put("Test1","Test2");
        a.put("TestA","TestB");

        b.put("Test1","Test2");
        b.put("TestA","TestB");

        /*通过迭代器打印输出*/
        Iterator iterator = b.entrySet().iterator();

        while (iterator.hasNext()){
            Map.Entry bb = (Map.Entry) iterator.next();
            System.out.println("打印JSONObject 的key和value:"+bb.getKey()+bb.getValue());
        }

        System.out.println("打印map的内容是:"+a.toString());
        System.out.println("打印JSONObject的内容是:"+b.toString());

    }
}