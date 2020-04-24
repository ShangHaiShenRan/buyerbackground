package com.hangyiyun.hangyiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.annotation.AuthToken;
import com.hangyiyun.hangyiyun.apiresult.Result;
import com.hangyiyun.hangyiyun.apiresult.ResultCode;
import com.hangyiyun.hangyiyun.utils.*;
import com.shsr.objectvo.hangyiyun.vo.user.PigcmsUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping(value = "/User",produces = {"application/json;charset=UTF-8"})
@Api(tags = "UserController", description = "企业管理")
public class UserController {

    /*读取配置文件中定义内容*/
    /*@Value("${host}")
    private String HOST;//获取域名信息

    @Value("${key}")
    private String Key;

    @Value("${userCode}")
    private String getCodeFormConfig;*/

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    final String HOST = "http://xyyapi.michain.tech";

    private static final String Key = "d811ad6ff50765b1e791318643239744";

    @Autowired
    private Util util;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private HttpTools httpTools;


    /**
     * @return JSONObject
     * @Author wangcc
     * @Description 根据名字验证登陆获得token
     * @Date 13:04 2020/4/1
     * @Param []
     **/
    @ApiOperation("商城登陆接口")
    @RequestMapping(value = "/loginByName", method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Result<JSONObject> loginByName(@RequestBody @NotNull PigcmsUser pigcmsUser) throws Exception {
        System.err.println(HOST);
        //logger.warn("打印输出的内容:"+HOST+"-----------"+Key+"--------------"+getCodeFormConfig);
        String path = "/admin/login/mall";

        Map<String, String> headers = new HashMap<String, String>();
        JSONObject bodys = new JSONObject();
        Map<String, String> parames = new HashMap<String, String>();

        if (pigcmsUser == null) {
            return new Result<JSONObject>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
        }

        /*判断用户是否经过平台方允许进入*/
        String phone = pigcmsUser.getPhone();
        String userCode = (String) redisUtil.get(phone + "COM");
        logger.info("userCode===" + userCode);
        if (!"COM3151811246".equals(userCode)) {
            return new Result<JSONObject>().setCode(ResultCode.INVALID_SCOPE).setMessage("店铺未批准").setData(null);//权限不对直接返回;
        }
        /*根据电话获取+"ACT"*/
        String encryptData = (String) redisUtil.get(phone + "ACT");
        if (StringUtils.isBlank(encryptData)) {
            logger.info("encryptData===" + encryptData);
            return new Result<JSONObject>().setCode(ResultCode.INVALID_SCOPE).setMessage("店铺未批准").setData(null);
        }

        String decrypt = DESUtil.decrypt(encryptData, Key);//解密

        JSONObject jsonData = JSONObject.parseObject(decrypt);
        String account = jsonData.getString("account");
        String pwd = jsonData.getString("passwd");

        if (account.isEmpty() || pwd.isEmpty()) {
            return new Result<JSONObject>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("店铺未注册").setData(null);
        }

        pigcmsUser.setAccount(account);//传入pwd，account
        pigcmsUser.setPassword(pwd);
        headers.put("Content-Type", "application/json");

        bodys.put("account", pigcmsUser.getAccount().toString());
        bodys.put("password", pigcmsUser.getPassword().toString());

        JSONObject jsonResp = null;
        try {
            jsonResp = httpTools.doPost(HOST, path, headers, bodys, parames);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result<JSONObject>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("登陆失败").setData(null);
        }

        /*获得状态*/
        String getRespStatus = jsonResp.getString("success");
        String tokenForResp = jsonResp.getString("token");
        String dataForResp = jsonResp.getString("data");

        /*存储到redise里*/
        redisUtil.set(tokenForResp, pigcmsUser.getAccount().toString());

        String getMallCodeForDataForResp = util.getValueForStr(dataForResp, "mallCode");

        /*非空判断*/
        if (!StringUtils.isNotBlank(getMallCodeForDataForResp)) {
            return new Result<JSONObject>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
        }

        if (null != getRespStatus && getRespStatus.equals("true") && StringUtils.isNotBlank(tokenForResp)) {

            /*redis存储token为key，用户名为value*/
            boolean setTokenResult = redisUtil.set(tokenForResp, getMallCodeForDataForResp);
            /*redis存储用户名为key,token为value，为了获取token将token放入第三方请求头*/
            //boolean setNameResult = redisUtil.set(getMallCodeForDataForResp, tokenForResp);暂时只存储一条数据
            /*redis存储用户名为key,token为value，为了获取token将token放入第三方请求头*/
            Long currentTime = System.currentTimeMillis();
            boolean setTimeResult = redisUtil.set(tokenForResp + getMallCodeForDataForResp, currentTime.toString());

            if (setTokenResult && setTimeResult) {
                return new Result<JSONObject>().setCode(ResultCode.SUCCESS).setMessage("成功").setData(jsonResp);
            } else {
                return new Result<JSONObject>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
            }
        } else {
            logger.error("返回值为空:", jsonResp.getString("message"));
            return new Result<JSONObject>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
        }
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
    public Result<JSONObject> loginOut(@RequestHeader("Authorization") String token) {
        /*验证token*/
        boolean hasTokenKey = redisUtil.hasKey(token.toString());
        if (!hasTokenKey) {
            return new Result<>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
        }
        /*获取name*/
        Object o = redisUtil.get(token.toString());
        if (null == o) {
            return new Result<>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
        }

        String mallCode = (String) o;
        String time = token + mallCode;

        /*删除redis数据*/
        redisUtil.del(token, mallCode, time);

        return new Result<>().setCode(ResultCode.SUCCESS).setMessage("成功").setData(null);
    }

}
