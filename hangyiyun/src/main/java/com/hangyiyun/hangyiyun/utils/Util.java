package com.hangyiyun.hangyiyun.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 重复内容 拆分封装
 *
 * @Param：
 * @Author: Wangcc
 * @Date: 2020/4/4 1:05
 */
@Component
public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    @Autowired
    private RedisUtil redisUtil;


    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author wangcc
     * @Description //TODO 封装：根据key拿到string类型中的value
     * @Date 1:21 2020/4/4
     * @Param []
     **/
    public String getValueForStr(String str, String key) {

        JSONObject jsonObject = JSONObject.parseObject(str);
        String value = jsonObject.getString(key);
        logger.info("获取内容:"+value.toString());
        return value;
    }

    /***
     * @Author wangcc
     * @Description //TODO 将对象转化JSONObject,在请求第三方接口
     * @Date 1:14 2020/4/4
     * @Param [HOST, path, method, object]
     * @return java.lang.String
     **/
    public JSONObject getResultForObj(Object object, String url, String method, Map<String, String> headers) {
        logger.info("打印传输进来的内容：" + object.toString());
        JSONObject result = new JSONObject();

        /*转换格式 obj => JSONObject*/
        String strObj = JSONObject.toJSONString(object);
        JSONObject JsonBody = JSONObject.parseObject(strObj);
        if (null == JsonBody) {
            result.put("status", "false");
            logger.error("转化obj对象错误！");
        }

        JSONObject respResult = null;

        /*判断连接类型，连接三方获取响应*/
        if (null != method && !method.equals("")) {

            logger.info(url,method,headers,JsonBody);

            respResult = HttpClientUtils.doPost(url, method, headers, JsonBody);

        }
        /*检测响应*/
        result = checkRespStatusAndGetMsg(respResult);

        return result;
    }

    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author wangcc
     * @Description //TODO 获得响应检测状态
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
