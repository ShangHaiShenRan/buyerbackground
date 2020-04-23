package com.hangyiyun.hangyiyun.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.annotation.AuthToken;
import com.hangyiyun.hangyiyun.utils.*;
import com.shsr.objectvo.hangyiyun.vo.user.PigcmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangcc
 * @Description 登陆
 * @Date 9:25 2020/4/2
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/User")
@Api(tags = "UserController",description  = "企业管理")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    final String HOST = "http://xyyapi.michain.tech";

    private static final String Key = "d811ad6ff50765b1e791318643239744";

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private Util util;


    /**
     * @return JSONObject
     * @Author wangcc
     * @Description 根据名字验证登陆获得token
     * @Date 13:04 2020/4/1
     * @Param []
     **/

    @ApiOperation("商城登陆接口")
    @RequestMapping(value = "/loginByName",method = RequestMethod.POST)
    public JSONObject loginByName(@RequestBody @NotNull PigcmsUser pigcmsUser) throws Exception {

        String path = "/admin/login/mall";
        String url = HOST + path;
        JSONObject jsonResp = new JSONObject();

        JSONObject result = new JSONObject();

        Map<String, String> headers = new HashMap<String, String>();
        JSONObject bodys = new JSONObject();
        Map<String, String> parames = new HashMap<String, String>();

        if (pigcmsUser != null) {

            /*判断用户是否经过平台方允许进入*/
            String phone = pigcmsUser.getPhone();
            String userCode = (String)redisUtil.get(phone+"COM");
            if(!"COM5704601385".equals(userCode)){
                return result;//权限不对直接返回;
            }

            /*根据电话获取+"ACT"*/
            String encryptData = (String)redisUtil.get(phone + "ACT");

            String decrypt = DESUtil.decrypt(encryptData, Key);//解密
            JSONObject jsonData = JSON.parseObject(decrypt);
            String account = jsonData.getString("account");
            String pwd = jsonData.getString("passwd");

            pigcmsUser.setAccount(account);//传入pwd，account
            pigcmsUser.setPassword(pwd);



            headers.put("Content-Type", "application/json");

            bodys.put("account", pigcmsUser.getAccount().toString());
            bodys.put("password", pigcmsUser.getPassword().toString());

            try {
                jsonResp = HttpTools.doPost(HOST,path,headers,bodys,parames);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null == jsonResp) {

                result.put("status", "false");
                logger.error("返回数据为空");
            }

            /*获得状态*/
            String getRespStatus = jsonResp.getString("success");
            String tokenForResp = jsonResp.getString("token");
            String dataForResp = jsonResp.getString("data");

            /*存储到redise里*/
            boolean set = redisUtil.set(tokenForResp, pigcmsUser.getAccount().toString());

            String getMallCodeForDataForResp = util.getValueForStr(dataForResp, "mallCode");
            /*非空判断*/
            if (StringUtils.isNotBlank(getMallCodeForDataForResp)) {

                if (null != getRespStatus && getRespStatus.equals("true") && StringUtils.isNotBlank(tokenForResp)) {

                    /*redis存储token为key，用户名为value*/
                    boolean setTokenResult = redisUtil.set(tokenForResp, getMallCodeForDataForResp);
                    /*redis存储用户名为key,token为value，为了获取token将token放入第三方请求头*/
                    //boolean setNameResult = redisUtil.set(getMallCodeForDataForResp, tokenForResp);暂时只存储一条数据
                    /*redis存储用户名为key,token为value，为了获取token将token放入第三方请求头*/
                    Long currentTime = System.currentTimeMillis();
                    boolean setTimeResult = redisUtil.set(tokenForResp + getMallCodeForDataForResp, currentTime.toString());

                    if (setTokenResult && setTimeResult) {
                       result = jsonResp;
                    } else {
                        result.put("status", "false");
                        logger.error("存储参数有误！");
                    }
                } else {
                    result.put("status", "false");
                    logger.error("返回值为空:", jsonResp.getString("message"));
                }
            } else {
                result.put("status", "false");
                logger.error("存储参数失败，获取mallcode失败！");
            }
        } else {
            result.put("status", "false");
            logger.error("输入有空，请检查后输入");
        }

        return result;
    }

    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author wangcc
     * @Description 退出
     * @Date 11:31 2020/4/4
     * @Param [token]
     **/
    @RequestMapping("/loginOut")
    @AuthToken
    @ApiOperation("企业退出的")
    public JSONObject loginOut(@RequestHeader("Authorization") String token ) {

        JSONObject result = new JSONObject();

        /*验证token*/
        boolean hasTokenKey = redisUtil.hasKey(token.toString());
        if (!hasTokenKey) {
            result.put("status", "false");
            logger.error("缓存中token过期");
            return result;
        }
        /*获取name*/
        Object o = redisUtil.get(token.toString());
        if (null == o) {
            result.put("status", "false");
            logger.error("缓存中name过期");
            return result;
        }

        String mallCode = (String) o;
        String time = token + mallCode;

        /*删除redis数据*/
        redisUtil.del(token, mallCode, time);

        result.put("status", "true");
        return result;

    }

}
