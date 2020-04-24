package com.hangyiyun.hangyiyun.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UUID;

public class UploadImageUtil {
    private static final int TIME_OUT = 8 * 1000;                          //超时时间
    private static final String CHARSET = "utf-8";                         //编码格式
    private static final String PREFIX = "--";                            //前缀
    private static final String BOUNDARY = UUID.randomUUID().toString();  //边界标识 随机生成
    private static final String LINE_END = "\r\n";                        //换行
    private static final String CONTENT_TYPE = "multipart/form-data";     //内容类型

    /**
     * post请求方法
     * */
    public static JSONObject postRequest(String requestUrl, final Map<String, String> strParams, final MultipartFile[] multipartFiles, HttpServletRequest request) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(requestUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(TIME_OUT);
            conn.setConnectTimeout(TIME_OUT);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);//Post 请求不能使用缓存
            //设置请求头参数
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", CONTENT_TYPE+";boundary=" + BOUNDARY);
            /**
             * 请求体
             */
            //上传参数
            DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
            //getStrParams()为一个
            dos.writeBytes( getStrParams(strParams).toString() );
            dos.flush();

            //文件上传
            StringBuilder fileSb = new StringBuilder();
            for (MultipartFile multipartFile:multipartFiles){
                fileSb.append(PREFIX)
                        .append(BOUNDARY)
                        .append(LINE_END)
                        /**
                         * 这里重点注意： name里面的值为服务端需要的key 只有这个key 才可以得到对应的文件
                         * filename是文件的名字，包含后缀名的 比如:abc.png
                         */
                        .append("Content-Disposition: form-data; name=\"file\"; filename=\""
                                + multipartFile.getOriginalFilename() + "\"" + LINE_END)
                        .append("Content-Type:" +multipartFile.getContentType()+ LINE_END) //此处的ContentType不同于 请求头 中Content-Type
                        .append("Content-Transfer-Encoding: 8bit" + LINE_END)
                        .append(LINE_END);// 参数头设置完以后需要两个换行，然后才是参数内容
                dos.writeBytes(fileSb.toString());
                dos.flush();

                //转化绝对路径
                String realPath=request.getServletContext().getRealPath(multipartFile.getOriginalFilename());
                File file=new File(realPath);

                InputStream is = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1){
                    dos.write(buffer,0,len);
                }
                is.close();
                dos.writeBytes(LINE_END);
            }
            //请求结束标志
            dos.writeBytes(PREFIX + BOUNDARY + PREFIX + LINE_END);
            dos.flush();
            dos.close();
            //读取服务器返回信息
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return JSONObject.parseObject(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 对post参数进行编码处理
     * */
    private static StringBuilder getStrParams(Map<String,String> strParams){
        StringBuilder strSb = new StringBuilder();
        for (Map.Entry<String, String> entry : strParams.entrySet() ){
            strSb.append(PREFIX)
                    .append(BOUNDARY)
                    .append(LINE_END)
                    .append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINE_END)
                    .append("Content-Type: text/plain; charset=" + CHARSET + LINE_END)
                    .append("Content-Transfer-Encoding: 8bit" + LINE_END)
                    .append(LINE_END)// 参数头设置完以后需要两个换行，然后才是参数内容
                    .append(entry.getValue())
                    .append(LINE_END);
        }
        return strSb;
    }
}
