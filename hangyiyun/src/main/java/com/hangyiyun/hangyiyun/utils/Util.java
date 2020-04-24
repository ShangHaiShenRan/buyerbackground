package com.hangyiyun.hangyiyun.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 重复内容 拆分封装
 *
 * @Param：
 * @Author: Wangcc
 * @Date: 2020/4/4 1:05
 */
@Component
@Scope("prototype")
public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private HttpTools httpTools;

    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author wangcc
     * @Description 封装：根据key拿到string类型中的value
     * @Date 1:21 2020/4/4
     * @Param []
     **/
    public String getValueForStr(String str, String key) {

        JSONObject jsonObject = JSONObject.parseObject(str);
        String value = jsonObject.getString(key);
        logger.info("获取内容:" + value.toString());
        return value;
    }

    /***
     * @Author wangcc
     * @Description 将对象转化JSONObject, 在请求第三方接口
     * @Date 1:14 2020/4/4
     * @Param [HOST, path, method, object]
     * @return java.lang.String
     **/
    public JSONObject getResultForObj(Object object, String host, String path, String method, Map<String, String> headers) throws IOException {
        logger.info("打印传输进来的内容：" + object.toString());
        JSONObject result = new JSONObject();




        /*转换格式 obj => JSONObject*/
        JSONObject jsonBody = (JSONObject) JSONObject.toJSON(object);

        logger.info("打印转化后的JSONObject对象内容" + jsonBody.toString());

        if (null == jsonBody) {
            result.put("status", "false");
            logger.error("转化obj对象错误！");
        }

        JSONObject respResult = null;

        /*判断连接类型，连接三方获取响应*/
        Map<String, String> parames = new HashMap<String, String>();
        respResult = httpTools.doPost(host, path, headers, jsonBody, parames);

        //respResult = HttpClientUtils.doPost(url, method, headers, JsonBody)
        /*检测响应*/
        result = checkRespStatusAndGetMsg(respResult);

        return result;
    }

    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author wangcc
     * @Description 获得响应检测状态
     * @Date 0:44 2020/4/6
     * @Param [jsonObject]
     **/
    public JSONObject checkRespStatusAndGetMsg(JSONObject jsonObject) {
        JSONObject result = new JSONObject();

        String successForResp = jsonObject.getString("success");
        String msgForResp = jsonObject.getString("message");

        if (null == jsonObject || null == successForResp || successForResp.equals("false")) {
            result.put("ststus", "false");
            logger.error("获取三方接口失败！消息:" + msgForResp);
        } else {
            result = jsonObject;
        }
        return result;
    }


    public String getTokenForRedis(String key) {
        String result = "";
        if (redisUtil.hasKey(key)) {
            Object o = redisUtil.get(key);
            if (null == o || o.equals("")) {
                String jsonResult = (String) o;
                result = jsonResult;
            }
        }
        return result;
    }

}
