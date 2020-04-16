package com.hangyiyun.hangyiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.utils.HttpClientUtils;
import com.hangyiyun.hangyiyun.utils.HttpUtils;
import com.hangyiyun.hangyiyun.utils.Util;
import com.shsr.objectvo.vo.good.GoodsInfoBaseVO;
import com.shsr.objectvo.vo.good.GoodsInfoVO;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/*
 * 功能描述: <br>
 * 〈〉 商品接口
 * @Param:
 * @Return:
 * @Author: 骄傲的骨傲天
 * @Date: 2020/3/29 13:33
 */
@RestController
@RequestMapping("/Goods")
public class GoodsController {


    int test = 0;

    final String HOST="http://xyyapi.michain.tech";

    private static final Logger logger = LoggerFactory.getLogger(MallController.class);

    @Autowired
    private Util util;

    /**
     * @Author wangcc
     * @Description //TODO 商品添加
     * @Date 11:39 2020/4/6
     * @Param [goodsInfoVO]
     * @return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/goodsinfos",method = RequestMethod.POST)
    public JSONObject addGoods(@RequestBody GoodsInfoVO goodsInfoVO){
        JSONObject result = new JSONObject();

        String path="/admin/goodsinfos";
        String url = HOST+path;
        String method = "POST";

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        result = util.getResultForObj(goodsInfoVO,url,method,headers);

        return result;
    }

    /**
     * @Author wangcc
     * @Description //TODO 商品修改
     * @Date 11:40 2020/4/6
     * @Param [goodsInfoVO]
     * @return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/goodsinfos",method = RequestMethod.PUT)
    public JSONObject updataGoods(@RequestBody GoodsInfoVO goodsInfoVO){
        JSONObject result = new JSONObject();

        String path = "/admin/goodsinfos";
        String url = HOST+path;

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        result = util.getResultForObj(goodsInfoVO,url,"PUT",headers);

        return result;
    }


    @RequestMapping("/selectByPag")
    public JSONObject selectByPage(@RequestParam String pageNum ,String pageSize,String goodsCategory,String goodsAttributes,String goodsName ){
        JSONObject result = new JSONObject();

        String path = "/admin/goodsinfos/insales";
        String url = HOST+path;
        //String params = "pageNum="+pageNum.toString()+"pageSize="+pageSize.toString()+"goodsCategory="+goodsAttributes.toString()+"goodsCategory="+goodsCategory.toString()+"goodsName="+goodsName.toString();

        Map<String,String> params = new HashMap<String,String>();
        Map<String,String> headers = new HashMap<String,String>();

        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        params.put("goodsCategory",goodsCategory);
        params.put("goodsAttributes",goodsAttributes);
        params.put("goodsName",goodsName);


        try {
            HttpResponse httpResponse = HttpUtils.doGet(HOST, path, "", headers, params);
            logger.info("请求地址是:"+httpResponse.toString());
            result = JSONObject.parseObject(EntityUtils.toString(httpResponse.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //JSONObject jsonObjResult = HttpClientUtils.doGet(url, headers, params);

        //result = util.checkRespStatusAndGetMsg(jsonObjResult);

        return result;
    }

    @RequestMapping("/selectById")
    public JSONObject selectById(){

        JSONObject result = new JSONObject();

        String path = "/admin/goodsinfos/123";
        String url = HOST+path;

        HttpResponse httpResponse = null;

        Map<String,String> params = new HashMap<String,String>();
        Map<String,String> headers = new HashMap<String,String>();

        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        try {
            httpResponse = HttpUtils.doGet(HOST, path, "", headers, params);
            logger.info("请求地址是:"+httpResponse.toString());
            result = JSONObject.parseObject(EntityUtils.toString(httpResponse.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    public void test(){
        System.out.println("1");
    }
}
