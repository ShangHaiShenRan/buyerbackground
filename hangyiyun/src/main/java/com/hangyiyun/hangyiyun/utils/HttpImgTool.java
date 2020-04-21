package com.hangyiyun.hangyiyun.utils;


import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.controller.UserController;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @创建人: wangcc
 * @创建时间: 2020/4/20
 * @描述:
 **/
public class HttpImgTool {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public static JSONObject uploadFile(String requestUrl, final MultipartFile multipartFile) throws IOException {

        JSONObject result = new JSONObject();

        HttpPost post = new HttpPost(requestUrl);


        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addBinaryBody("file",multipartFile.getInputStream(), ContentType.MULTIPART_FORM_DATA,multipartFile.getOriginalFilename());

        HttpEntity entity = builder.build();//将上面的内容转化成实体;

        post.setEntity(entity);

        CloseableHttpClient client = HttpClients.createDefault();//创建一个默认的客户端

        CloseableHttpResponse resp = client.execute(post);

        int statusCode = resp.getStatusLine().getStatusCode();
        if(200 == statusCode){
            HttpEntity respBody = resp.getEntity();
            result = JSONObject.parseObject(EntityUtils.toString(respBody));
        }
        return result;
    }

    @Test
    public void test() throws IOException {
        String webPath = "http://xyyapi.michain.tech/admin/upload/image";

        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Content-Type", "multipart/form-data; boundary=<calculated when request is sent>");


        String s = readFile();
        System.out.println(s.toString());
        
        //System.out.println("打印结果是:" + jsonObject.toString());
    }


    /**
     *测试读取本地文件
     **/
    private String readFile() {
        File file02 = new File("E:/Test/OIP.jpg");
        FileInputStream is = null;
        StringBuilder stringBuilder = null;
        try {
            if (file02.length() != 0) {
                /**
                 * 文件有内容才去读文件
                 */
                is = new FileInputStream(file02);
                InputStreamReader streamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(streamReader);
                String line;
                stringBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    // stringBuilder.append(line);
                    stringBuilder.append(line);
                }
                reader.close();
                is.close();
            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);

    }




}
