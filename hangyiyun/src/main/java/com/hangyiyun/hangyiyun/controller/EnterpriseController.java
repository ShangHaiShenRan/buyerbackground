package com.hangyiyun.hangyiyun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.utils.DESUtil;
import com.hangyiyun.hangyiyun.utils.HttpClientUtils;
import com.hangyiyun.hangyiyun.utils.HttpTools;
import com.hangyiyun.hangyiyun.utils.HttpUtils;
import com.shsr.objectvo.vo.company.Enterprise;
import com.shsr.objectvo.vo.user.PigcmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author zl
 * 备注：后期将公用的信息，如: 服务器IP地址,加密的key，通过配置文件管理，使用通过读取配置文件实现;
 * 用户登录注册接口
 */
@RestController
@RequestMapping("/Enterprise")
@Api(tags = "EnterpriseController",description  = "云登陆注册管理")
public class EnterpriseController {
    private final String HOST = "https://enterprise.michain.tech";
    private final String KEY = "d811ad6ff50765b1e791318643239744";

    private static final Logger logger = LoggerFactory.getLogger(EnterpriseController.class);

    /**
     * @Author zlz
     * @eviewer wangcc 更改内容:
     * 1.更改返回类型；
     * 2.更换连接三方方法;
     * 3.进行简单代码规范;
     * 4.将调用开店部分参数进行了整合
     * 中台注册接口
     */
    @RequestMapping("/register")
    @ApiOperation("云平台注册")
    public JSONObject register(Enterprise enterprise) {

        String path = "/api/third/registerapi";
        String method = "POST";
        String url = HOST + path;

        JSONObject result = new JSONObject();

        logger.info("打印内容:"+enterprise.toString());

        try {
            enterprise.setUserCode("COM3151811246");//设置代理商编号
            enterprise.setPlatformCode("COM26506");//设置平台编码
            enterprise.setOrigin(8);//注册来源 ，固定填8
            enterprise.setRegisterType(0);//注册类型 0企业 1个人
            enterprise.setMerchantType(2);//商户类型 0卖家 1买家 2买卖家
            enterprise.setTimestamp(new Date(System.currentTimeMillis()));//13位时间戳


            /*加密, 加密的key是一个token,是双方提前约定好的*/
            String enterpriseJson = JSONObject.toJSONString(enterprise);
            String encryptionCode = DESUtil.encrypt(enterpriseJson, KEY);
            String decrypt = DESUtil.decrypt(encryptionCode, KEY);

            System.out.println("打印解密后的内容:"+decrypt.toString());

            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/x-www-form-urlencoded");//接口要求格式
            //headers.put("Content-Type", "application/json");//接口要求格式

            Map<String,String> parames = new HashMap<>();
            parames.put("userCode", "COM5704601385");//代理商编码，固定: COM5704601385
            parames.put("encryptMsg", encryptionCode);//加密数据

            //调用注册接口
            //JSONObject jsonResp = HttpClientUtils.doPost(url, method, headers, bodys);
            /*Boolean respStatus = jsonResp.getBoolean("status");//获得返回内容中状态;
            JSONObject respData = jsonResp.getJSONObject("data");//获得返回内容中状态;*/


            JSONObject bodys = new JSONObject();

           // HttpResponse httpResponse = HttpUtils.doPost(HOST, path, method, headers, parames,bodys);
            JSONObject jsonResp = HttpTools.doPost(HOST, path, headers, bodys, parames);

            //HttpEntity entity = httpResponse.getEntity();

            //String s = EntityUtils.toString(entity);

            System.out.println("获取内容是:"+jsonResp);



            /*验证返回结果为true时和返回消息不为空(接口验证时出现过返回为true但是结果为空注册失败的情况)，直接开通商城*/
            /*if (respStatus && respData != null && "".equals(respData)) {

                String companyCode = respData.getString("companyCode");
                enterprise.setCompanyCode(companyCode);//掉用开店方法前，将返回的消息整合成一个实体类;

                JSONObject openMallResult = openMall(enterprise);
                result = openMallResult;
                logger.info(result.toJSONString());
            } else {
                result = jsonResp;//注册失败，将失败消息返回前端
                logger.info(result.toJSONString());
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            result.put("status", false);
            result.put("message", "系统错误！");
            result.put("data", null);

        }
        return result;
    }

    /*
     * 中台登录接口
     * @Reviewer: Wangcc 更改内容:
     *      1.删除 部分注释;
     *      2.将返回类型改变为JSONObject;
     *      3.删除try{}catch() 代码块
     * */
    @RequestMapping("/login")
    @ApiOperation("云平台登陆")
    public JSONObject login(PigcmsUser pigcmsUser) {

        JSONObject result = new JSONObject();

        String path = "/login";
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        JSONObject bodys = new JSONObject();
        bodys.put("phone", pigcmsUser.getPhone());
        bodys.put("password", pigcmsUser.getPassword());
        bodys.put("loginVerifyCode", "xyypt20");

        JSONObject post = HttpClientUtils.doPost(HOST + path, "POST", headers, bodys);

        result = post;
        return result;
    }


    /*
     * 商城开通接口
     * @Reviewer Wangcc
     * 更改内容:
     *  1.将两个参数变成一个参数，所有内容都通过Enterprise 传递，这个后期拆分方便;
     *
     * */
    @ApiOperation("saas平台开店")
    public JSONObject openMall(Enterprise enterprise) throws Exception {
        String pathMall = "/api/third/mall/open";
        String method = "POST";

        JSONObject openMall = new JSONObject();
        openMall.put("companyCode",enterprise.getCompanyCode());//注册公司码
        openMall.put("timestamp",enterprise.getTimestamp());//注册时间

        String encryptReq = DESUtil.encrypt(openMall.toJSONString(), KEY);//对称加密 Key是双方约定的
        Map<String, String> headersMall = new HashMap<String, String>();
        headersMall.put("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> querysMall = new HashMap<String, String>();
        querysMall.put("userCode", "COM5704601385");//写死;
        querysMall.put("encryptMsg", encryptReq);//导入加密内容;

        Map<String, String> bodyMall = null;//参数需要

        HttpResponse httpResponseMall = HttpUtils.doPost(HOST, pathMall, method, headersMall, querysMall, bodyMall);

        /*格式转化*/
        String openMallResp = EntityUtils.toString(httpResponseMall.getEntity());
        JSONObject jsonResp = JSONObject.parseObject(openMallResp);

        return jsonResp;
    }
}
