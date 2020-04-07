package com.hangyiyun.hangyiyun.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * httpclient封装组件,后期可以了解feign将自己写的重构成feign
 *
 * @Param：
 * @Author: Wangcc
 * @Date: 2020/4/5 14:15
 */
public class HttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);


    /**
     * @Author wangcc
     * @Description //TODO post请求
     * @Date 23:58 2020/4/5
     * @Param [postUrl, headers, bodys]
     * @return com.alibaba.fastjson.JSONObject
     **/
    public static JSONObject doPost(String postUrl,String method,Map<String,String> headers, JSONObject bodys){
        //OutputStreamWriter out = null;
        PrintWriter out = null;
        BufferedReader br = null;

        String result = "";
        JSONObject jsonResult = new JSONObject();
        try {
            URL url = new URL(postUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //请求方式
            conn.setRequestMethod(method);

            for (Map.Entry<String, String> param : headers.entrySet()) {
                conn.setRequestProperty(param.getKey(),param.getValue());
            }

            conn.setDoOutput(true);
            conn.setDoInput(true);

            /*调接口*/
            //获取URLConnection对象对应的输出流
            //out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out = new PrintWriter(conn.getOutputStream());
            //发送请求参数即数据 转化类型
            out.write(String.valueOf(bodys));
            //flush输出流的缓冲
            out.flush();


            /*获取返回结果*/
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null){
                result += str;
            }
            System.out.println(result);
            //关闭流
            is.close();
            //断开连接
            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonResult = JSONObject.parseObject(result);
        logger.info("成功获取三方返回数据："+jsonResult);

        return  jsonResult;
    }


    /**
     * @Author wangcc
     * @Description //TODO Get请求
     * @Date 0:11 2020/4/6
     * @Param [url, headers, param]
     * @return java.lang.String
     **/
    public static JSONObject doGet(String url,Map<String,String> headers, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            logger.debug("请求地址是:"+urlNameString.toString());

            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();


            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(),header.getValue());
                //httpPost.setHeader(param.getKey(), String.valueOf(param.getValue()));
            }

            // 设置通用的请求属性
//            connection.setRequestProperty("accept", "*/*");
//            connection.setRequestProperty("connection", "Keep-Alive");
//            connection.setRequestProperty("user-agent",
//                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//            connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
//            connection.setRequestProperty("Authorization",token);
            
            
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        JSONObject jsonResult = new JSONObject();
        jsonResult = JSONObject.parseObject(result);

        return jsonResult;
    }


}
