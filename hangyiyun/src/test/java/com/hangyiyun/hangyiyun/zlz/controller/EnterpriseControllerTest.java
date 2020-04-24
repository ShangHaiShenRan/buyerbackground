package com.hangyiyun.hangyiyun.zlz.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.apiResult.Result;
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
        /*enterprise=new Enterprise();
        enterprise.setPhone("18851886188");
        enterprise.setPassword("Zlz13117500158");
        enterprise.setCompanyName("This is Test Data:数据测试数据测试9");*/
        pigcmsUser = new PigcmsUser();
        pigcmsUser.setPhone("17611118822");

        Result<JSONObject> result = userController.loginByName(pigcmsUser);
        String message = result.getMessage();
        JSONObject data = result.getData();
        System.out.println(message.toString() +"------------"+data.toString());

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