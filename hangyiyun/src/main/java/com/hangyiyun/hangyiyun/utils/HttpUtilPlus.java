package com.hangyiyun.hangyiyun.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/*
 * HttpURLConnetion封装类
 * zlz
 * */

@Component
public class HttpUtilPlus {

    private  final Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    public JSONObject get(String argUrl, Map<String, String> params, Map<String, String> headers)throws Exception {
        String urlFromParams = createUrlFromParams(argUrl, params);
        URL url = new URL(urlFromParams);
        //得到connection对象。
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //设置请求方式
        connection.setRequestMethod("GET");
        if(headers != null){
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        //连接
        connection.connect();
        //得到响应码
//        int responseCode = connection.getResponseCode();
        StringBuilder result = new StringBuilder();
        //得到响应流
        InputStream is = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "utf-8"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }

        //关闭流
        is.close();
        connection.disconnect();

        return JSONObject.parseObject(result.toString());
    }

    /**
     * 将传递进来的参数拼接成 url
     **/
    public static String createUrlFromParams(String url, Map<String, String> params)throws Exception {
        if(params==null) return url;

        StringBuilder sb = new StringBuilder();
        sb.append(url);
        if (url.indexOf('&') > 0 || url.indexOf('?') > 0) sb.append("&");
        else sb.append("?");
        for (Map.Entry<String, String> urlParams : params.entrySet()) {
            String value = urlParams.getValue();
            //对参数进行 utf-8 编码,防止头信息传中文
            String urlValue = URLEncoder.encode(value, "UTF-8");
            sb.append(urlParams.getKey()).append("=").append(value).append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();

    }



    /*
    * POST请求
    * */
    public JSONObject post(String argUrl, Map<String, String> headers, Map<String,String> postData,Map<String,String> bodys) throws Exception{
        URL url = new URL(argUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);

        if(headers != null){
//            设置请求头参数
            for (Map.Entry<String, String> param : headers.entrySet()) {
                connection.setRequestProperty(param.getKey(),param.getValue());
            }
        }
        DataOutputStream out  = new DataOutputStream(connection.getOutputStream());
        //参数转换key=value
        if(postData!=null)
            out.writeBytes(transFormPOSTParameter(postData));
        System.err.println(transFormPOSTParameter(postData));
        out.close();
        connection.connect();

        StringBuilder result = new StringBuilder();
        //得到响应流
        InputStream is = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line = "";
        while ((line = reader.readLine()) != null) {
            result.append(line).append("\n");
        }

        //关闭流
        is.close();
        connection.disconnect();

        return JSONObject.parseObject(result.toString());
    }

    /*
     * zlz
     * 将post参数转换成key=value格式
     * */
    public String transFormPOSTParameter(Map<String,String> query)throws Exception{
        StringBuilder stringBuilder=new StringBuilder();
        for (Map.Entry<String, String> entry : query.entrySet()) {
            stringBuilder.append(entry.getKey()+"="+entry.getValue()+"&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }



}
