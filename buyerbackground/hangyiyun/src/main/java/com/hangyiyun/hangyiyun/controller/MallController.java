package com.hangyiyun.hangyiyun.controller;

import com.hangyiyun.hangyiyun.util.HttpUtils;
import com.shsr.objectvo.vo.member.Member;
import org.apache.catalina.User;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/Mall")
public class MallController {
    final String HOST="http://xyyapi.michain.tech";

    /*
     * 功能描述: <br>
     * 〈〉  商城查询接口（根据id查询）
     * @Param: id(商城id)
     * @Return:Map集合
     * @Author: 骄傲的骨傲天
     * @Date: 2020/3/29 11:39
     */
    @RequestMapping(value = "/by/id",method = RequestMethod.GET)
    public Map<String,Object> selectMallByID(String id){
        System.out.println("获得前端发送的请求");
        String path="/admin/mall/by/id";
        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
//        设置token
//        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        querys.put("id",id);

        try {
            HttpResponse response = HttpUtils.doGet(HOST, path, method, headers, querys);
            System.out.println("商城查询接口 get Date():"+response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /*
     * 功能描述: <br>
     * 〈〉商城新增接口
     * @Param:
     * @Return: Map集合
     * @Author: 骄傲的骨傲天
     * @Date: 2020/3/29 11:43
     */
    @RequestMapping(value = "/addMall",method = RequestMethod.POST)
    public Map<String,Object> addMall(){
        String path="admin/mall";
        String method = "POST";
        Map<String, String> headers = new HashMap<String, String>();
//        设置token
//        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();



        return null;
    }


    /*
     * 功能描述: <br>
     * 〈〉商城修改接口
     * @Param:
     * @Return: Map集合
     * @Author: 骄傲的骨傲天
     * @Date: 2020/3/29 11:47
     */
    @RequestMapping(value = "/editMall",method = RequestMethod.POST)
    public Map<String,Object> editMall() { return  null;
    }

}
