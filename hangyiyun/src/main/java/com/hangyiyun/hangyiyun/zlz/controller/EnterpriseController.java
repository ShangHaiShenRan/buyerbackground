package com.hangyiyun.hangyiyun.zlz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.utils.DESUtil;
import com.hangyiyun.hangyiyun.utils.HttpClientUtils;
import com.hangyiyun.hangyiyun.utils.HttpUtils;
import com.hangyiyun.hangyiyun.zlz.entity.Enterprise;
import com.hangyiyun.hangyiyun.zlz.returnforobj.Data;
import com.hangyiyun.hangyiyun.zlz.returnforobj.OpenMall;
import com.hangyiyun.hangyiyun.zlz.returnforobj.EnterpriseRegister;
import com.shsr.objectvo.vo.user.PigcmsUser;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author zlz
 * 用户登录注册接口
 */
@RestController
@RequestMapping("/Enterprise")
public class EnterpriseController {
    private final String HOST="https://enterprise.michain.tech";
    private final String KEY="d811ad6ff50765b1e791318643239744";

    /**
     * @Author zlz
     * 中台注册接口
     */
    @RequestMapping("/register")
    public String register(Enterprise enterprise)  {
        try {
            //设置代理商编号
            enterprise.setUserCode("COM3151811246");
            //设置平台编码
            enterprise.setPlatformCode("COM26506");
//        注册来源 ，固定填8
            enterprise.setOrigin(8);
//        注册类型 0企业 1个人
            enterprise.setRegisterType(0);
//        商户类型 0卖家 1买家 2买卖家
            enterprise.setMerchantType(2);
//        13位时间戳
            enterprise.setTimestamp(new Date(System.currentTimeMillis()));
//        对Enterprise企业实体类进行json加密
            String enterpriseJson = JSONObject.toJSONString(enterprise);
            String encryptionCode = DESUtil.encrypt(enterpriseJson, KEY);
            //注册超级管理员
            String path="/api/third/registerapi";
            String method="POST";
//            设置请求头
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type","application/x-www-form-urlencoded");
//            设置请求参数
            Map<String, String> querys = new HashMap<String, String>();
//            代理商编码，固定: COM5704601385
            querys.put("userCode","COM5704601385");
//            加密数据
            querys.put("encryptMsg",encryptionCode);

//            设置请求体
            Map<String, String> body =null;
            HttpResponse httpResponse = HttpUtils.doPost(HOST, path, method, headers, querys, body);
            String enterpriseRegisterJson= EntityUtils.toString(httpResponse.getEntity());
//            将返回json转换成对应的返回对象
            EnterpriseRegister enterpriseRegister = JSON.parseObject(enterpriseRegisterJson,EnterpriseRegister.class);
            Data data=JSON.parseObject(enterpriseRegister.getData(),Data.class);
            //如果注册企业成功开通卖家服务
            if(enterpriseRegister.isStatus()){
               return openMall(data,enterprise);
            }
            return enterpriseRegisterJson;
        }catch (Exception e){
            e.printStackTrace();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("status",false);
            map.put("message","服务器错误");
            map.put("data",null);
            return JSONObject.toJSONString(map);
        }
    }

    /*
    * 中台登录接口
    * */
    @RequestMapping("/login")
    public String login(PigcmsUser pigcmsUser){
        try {
            String path="/login";
            String method="POST";
//        请求头
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type","application/json");
//        请求参数
            Map<String, String> querys =null;

//        请求体
            JSONObject bodys =new JSONObject();
            bodys.put("phone",pigcmsUser.getPhone());
            bodys.put("password",pigcmsUser.getPassword());
            bodys.put("loginVerifyCode","xyypt20");

            JSONObject post = HttpClientUtils.doPost(HOST + path, "POST", headers, bodys);
            return post.toString();
        }catch (Exception e){
            e.printStackTrace();
            return "{\n" +
                    "\"status\": false,\n" +
                    "\"message\": \"服务器内部错误\",\n" +
                    "}";
        }


    }


    /*
    * 商城开通接口
    * */
    public String openMall(Data data,Enterprise enterprise) throws Exception {
        String pathMall="/api/third/mall/open";
        String method="POST";
        //设置企业编码
        OpenMall openMall=new OpenMall();
//                设置企业编号
        openMall.setCompanyCode(data.getCompanyCode());
//                注册时间
        openMall.setTimestamp(enterprise.getTimestamp());
//                加密
        String dataJson = JSONObject.toJSONString(openMall);
        String dataCode = DESUtil.encrypt(dataJson, KEY);
//                请求头
        Map<String, String> headersMall = new HashMap<String, String>();
        headersMall.put("Content-Type","application/x-www-form-urlencoded");
//                请求参数
        Map<String, String> querysMall = new HashMap<String, String>();
        querysMall.put("userCode","COM5704601385");
        querysMall.put("encryptMsg",dataCode);
        Map<String, String> bodyMall =null;
        HttpResponse httpResponseMall = HttpUtils.doPost(HOST, pathMall, method, headersMall, querysMall, bodyMall);
        String openMallMessage=EntityUtils.toString(httpResponseMall.getEntity());
        return openMallMessage;
    }

}
