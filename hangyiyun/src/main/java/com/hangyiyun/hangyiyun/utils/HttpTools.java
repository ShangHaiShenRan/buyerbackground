package com.hangyiyun.hangyiyun.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人: wangcc
 * @创建时间: 2020/4/19
 * @描述:
 **/
@Component
@Scope("prototype")
public class HttpTools {

    /**
     * @Author Wangcc
     * @Description post请求封装工具类
     * @Date 11:12 2020/4/20
     * @Param [host, path, headers, bodys, parames]
     * @return com.alibaba.fastjson.JSONObject
     **/
    public static JSONObject doPost(String host, String path, Map<String,String> headers, Map<String,String> bodys, Map<String,String> parames) throws IOException {

        JSONObject result = new JSONObject();

        HttpPost post = new HttpPost(buildUrl(host,path,parames));

        /*传入头部*/
        for (Map.Entry<String,String> header :headers.entrySet()){
            post.setHeader(header.getKey(),header.getValue());
        }

        /*传入bodys  坑点！！！！ 之前是通过常用的list传入，用的NameValuePair 会出现 错误请求的情况*/
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String,String> mt:bodys.entrySet()){
            jsonObject.put(mt.getKey(),mt.getValue());
        }
        post.setEntity(new StringEntity(jsonObject.toString()));

        CloseableHttpClient requestClient = HttpClients.createDefault();//创建一个默认请求客户端；

        CloseableHttpResponse response = requestClient.execute(post);//发送请求，获取返回内容;

        StatusLine statusLine = response.getStatusLine();//获取返回状态头;
        statusLine.getStatusCode();//获得状态码;
        statusLine.getProtocolVersion();//获得返回http版本;
        statusLine.getReasonPhrase();//获得的的返回....Emmmm 忘了叫什么了.....

        HttpEntity entity = response.getEntity();//获得返回的响应体 Body
        if (entity != null) {
            String strResp = EntityUtils.toString(entity);

            JSONObject jsonResp = JSONObject.parseObject(strResp);

            result = jsonResp;
        }
        return result;

    }


    /**
     * @Author Wangcc
     * @Description get请求
     * @Date 11:27 2020/4/20
     * @Param [host, path, headers, parames]
     * @return com.alibaba.fastjson.JSONObject
     **/
    public static JSONObject doGet(String host,String path,Map<String,String> headers,Map<String,String> parames) throws IOException {

        JSONObject result = new JSONObject();

        HttpGet get = new HttpGet(buildUrl(host,path,parames));//创建一个get请求;

        /*头文件设置*/
        for (Map.Entry<String,String> header :headers.entrySet()){
            get.setHeader(header.getKey(),header.getValue());
        }

        CloseableHttpClient req = HttpClients.createDefault();//创建一个默认的客户端;

        CloseableHttpResponse resp = req.execute(get);//获得响应消息;
        if (resp != null) {
            StatusLine statusLine = resp.getStatusLine();//获得返回状态行;
            int statusCode = statusLine.getStatusCode();//返回请求状态;
            if(200 == statusCode){
                String strResp = EntityUtils.toString(resp.getEntity());
                result = JSONObject.parseObject(strResp);
            }
        }
        return result;
    }

    /*将parames,host,path 进行拼接*/
    private static String buildUrl(String host, String path, Map<String, String> parames) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(host);
        if (!StringUtils.isBlank(path)) {
            sbUrl.append(path);
        }
        if (null != parames) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : parames.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (StringUtils.isBlank(query.getKey()) && !StringUtils.isBlank(query.getValue())) {
                    sbQuery.append(query.getValue());
                }
                if (!StringUtils.isBlank(query.getKey())) {
                    sbQuery.append(query.getKey());
                    if (!StringUtils.isBlank(query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }


    @Test
    public void test() throws IOException {

        String HOST = "http://xyyapi.michain.tech";
        String path = "/admin/goodsinfos/123";

        Map<String,String> headers = new HashMap<String,String>();
        Map<String,String> parames = new HashMap<String,String>();

        headers.put("Content-Type","application/json;charset=UTF-8");


        JSONObject jsonObject = doGet(HOST, path, headers, parames);

        System.out.println("打印返回内容是"+jsonObject.toString());

    }

}
