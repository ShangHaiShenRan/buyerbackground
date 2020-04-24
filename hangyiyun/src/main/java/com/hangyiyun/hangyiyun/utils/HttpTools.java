package com.hangyiyun.hangyiyun.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @创建人: wangcc
 * @创建时间: 2020/4/19
 * @描述:
 **/
public class HttpTools {


    /**
     * @Author Wangcc
     * @Description post请求封装工具类
     * @Date 11:12 2020/4/20
     * @Param [host, path, headers, bodys, parames]
     * @return com.alibaba.fastjson.JSONObject
     **/
    public  JSONObject doPost(String host, String path, Map<String,String> headers, JSONObject bodys, Map<String,String> parames) throws IOException {

        JSONObject result = new JSONObject();

        HttpPost post = new HttpPost(buildUrl(host,path,parames));

        /*传入头部*/
        for (Map.Entry<String,String> header :headers.entrySet()){
            post.setHeader(header.getKey(),header.getValue());
        }

        /*传入bodys  坑点！！！！ 之前是通过常用的list传入，用的NameValuePair 会出现 错误请求的情况*/
        /*JSONObject jsonObject = new JSONObject();
        for (Map.Entry<String,String> mt:bodys.entrySet()){
            jsonObject.put(mt.getKey(),mt.getValue());
        }*/

//        一定要设置编码格式，不然乱码
        post.setEntity(new StringEntity(bodys.toString(),"UTF-8"));

        CloseableHttpClient requestClient = HttpClients.createDefault();//创建一个默认请求客户端；

        CloseableHttpResponse response = requestClient.execute(post);//发送请求，获取返回内容;

        StatusLine statusLine = response.getStatusLine();//获取返回状态头;
        int statusCode = statusLine.getStatusCode();//获得状态码;
        ProtocolVersion protocolVersion = statusLine.getProtocolVersion();//获得返回http版本;
        String reasonPhrase = statusLine.getReasonPhrase();//获得的的返回....Emmmm 忘了叫什么了.....

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
    public  JSONObject doGet(String host,String path,Map<String,String> headers,Map<String,String> parames) throws IOException {

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
    private  String buildUrl(String host, String path, Map<String, String> parames) throws UnsupportedEncodingException {
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

    /*
    * 文件上传post请求
    * */
    public JSONObject uploadImage(String url, String key, MultipartFile[] files, Map<String, String> paramter)throws Exception{
        CloseableHttpClient httpClient  = HttpClientBuilder.create().build();
        HttpPost httpPost=new HttpPost(url);
        CloseableHttpResponse response = null;

        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        if (files==null)
            return null;

        for (MultipartFile file : files) {
            long size = file.getSize();
            System.err.println(size);
            multipartEntityBuilder.addBinaryBody(key, file.getBytes(),ContentType.MULTIPART_FORM_DATA, files[0].getOriginalFilename());
        }
        // 第二个文件(多个文件的话，使用同一个key就行，后端用数组或集合进行接收即可)
//        File file2 = new File("C:\\Users\\JustryDeng\\Desktop\\头像.jpg");
        // 防止服务端收到的文件名乱码。 我们这里可以先将文件名URLEncode，然后服务端拿到文件名时在URLDecode。就能避免乱码问题。
        // 文件名其实是放在请求头的Content-Disposition里面进行传输的，如其值为form-data; name="files"; filename="头像.jpg"
//        multipartEntityBuilder.addBinaryBody(filesKey, file2, ContentType.DEFAULT_BINARY, URLEncoder.encode(file2.getName(), "utf-8"));
        // 其它参数(注:自定义contentType，设置UTF-8是为了防止服务端拿到的参数出现乱码)
        if(paramter!=null){
            ContentType contentType = ContentType.create("text/plain", Charset.forName("UTF-8"));
            for (Map.Entry<String, String> stringStringEntry : paramter.entrySet()) {
                multipartEntityBuilder.addTextBody(stringStringEntry.getKey(), stringStringEntry.getValue(), contentType);
            }
        }
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);

        response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();
        System.out.println("HTTPS响应状态为:" + response.getStatusLine());
        if (responseEntity != null) {
            System.out.println("HTTPS响应内容长度为:" + responseEntity.getContentLength());
            // 主动设置编码，来防止响应乱码
            String responseStr = EntityUtils.toString(responseEntity, StandardCharsets.UTF_8);
            System.err.println("HTTPS响应内容为:" + responseStr);
            return JSONObject.parseObject(responseStr);
        }
        return null;
    }

}
