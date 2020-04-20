package com.hangyiyun.hangyiyun.httpClientTest;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.utils.StringUtils;
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

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
public class httpClientTest {

    public static void main(String[] args) throws IOException {

        //String url = "http://www.baidu.com";//get请求
        String url = "http://xyyapi.michain.tech/admin/login/mall";//post请求;

        HttpPost httpPost = new HttpPost(url);

        /*添加请求头*/
        httpPost.setHeader("Content-Type","application/json;charset=UTF-8");

        Map<String,String> map = new HashMap<String,String>();
        map.put("account","admin001");
        map.put("password","123456");

        /*坑点，之前是通过常用的list传入，用的NameValuePair 会出现 错误请求的情况*/
        JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String,String> mt:map.entrySet()){
            jsonObject.put(mt.getKey(),mt.getValue());
        }

        httpPost.setEntity(new StringEntity(jsonObject.toString()));

        CloseableHttpClient aDefault = HttpClients.createDefault();//创建一个默认客户端

        CloseableHttpResponse response = aDefault.execute(httpPost);//http发送
        
        
        //获取响应状态码;
        StatusLine statusLine = response.getStatusLine();
        int statusCode = statusLine.getStatusCode();
        String reasonPhrase = statusLine.getReasonPhrase();
        ProtocolVersion protocolVersion = statusLine.getProtocolVersion();

        System.out.println("打印返回状态行:"+String.valueOf(statusCode)+reasonPhrase.toString()+protocolVersion.toString());

        //获取响应头
        Header[] allHeaders = response.getAllHeaders();

        for (Header header:allHeaders) {
            System.out.println("打印响应头内容是:"+header.getName()+":"+header.getValue());
        }
        //获取响应体
        HttpEntity entity = response.getEntity();

        String s = EntityUtils.toString(entity);

        System.out.println("打印获得的响应体是"+s.toString());
    }


    @Test
    public void TestHttp(){

        String HOST = "http://xyyapi.michain.tech";
        String path = "/admin/mall";

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type","application/json;charset=UTF-8");

        Map<String,String> bodys = new HashMap<String,String>();
        bodys.put("companyName","admin001");
        bodys.put("note","123456");
        bodys.put("name","123456");
        bodys.put("logo","123456");
        bodys.put("legalPersonName","123456");
        bodys.put("phone","123456");
        bodys.put("provinceCode","123456");
        bodys.put("cityCode","123456");
        bodys.put("contactAddress","123456");
        bodys.put("consumerWorkingTime","123456");

        Map<String,String> parames = new HashMap<String,String>();

        try {
            JSONObject jsonResp = doPost(HOST, path, headers, bodys, parames);
            System.out.println("打印返回内容是:"+jsonResp.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static JSONObject doPost(String host,String path, Map<String,String> headers,Map<String,String> bodys,Map<String,String> parames) throws IOException {

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

}



