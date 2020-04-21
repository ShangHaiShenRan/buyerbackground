package com.hangyiyun.hangyiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.apiresult.Result;
import com.hangyiyun.hangyiyun.apiresult.ResultCode;
import com.hangyiyun.hangyiyun.utils.HttpTools;
import com.hangyiyun.hangyiyun.utils.HttpUtils;
import com.hangyiyun.hangyiyun.utils.Util;
import com.shsr.objectvo.hangyiyun.vo.good.GoodsInfoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
@Api(tags = "GoodsController",description  = "商品管理")
@RestController
@RequestMapping(value = "/Goods" ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GoodsController {

    final String HOST="http://xyyapi.michain.tech";
    private static final Logger logger = LoggerFactory.getLogger(MallController.class);

    @Autowired
    private Util util;

    @Autowired
    private HttpTools httpTools;

    /**
     * @Author wangcc
     * @Description  商品添加
     * @Date 11:39 2020/4/6
     * @Param [goodsInfoVO]
     * @return com.alibaba.fastjson.JSONObject
     **/
    @ApiOperation(value = "商品添加")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "body",name = "goodsInfoVO",required=true,value = "商品详情")
    })
    @RequestMapping(value = "/goodsinfos",method = RequestMethod.POST)
    public Result<JSONObject> addGoods(@RequestBody GoodsInfoVO goodsInfoVO){
        JSONObject result = null;
        String path="/admin/goodsinfos";

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json; charset=UTF-8");

        Map<String,String> paramtes = new HashMap<String,String>();

//        Objcet==>JSONObject
        JSONObject body= (JSONObject) JSONObject.toJSON(goodsInfoVO);
        try {
            result = httpTools.doPost(HOST,path,headers,body,paramtes);
            return new Result<JSONObject>().setCode(ResultCode.SUCCESS).setMessage("添加成功").setData(result);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result<JSONObject>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("添加失败").setData(result);
        }
    }


    /**
     * @Author wangcc
     * @Description  商品修改
     * @Date 11:40 2020/4/6
     * @Param [goodsInfoVO]
     * @return com.alibaba.fastjson.JSONObject
     **/
    @ApiOperation("商品修改")
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

   /**
    * @Author Wangcc
    * @Description  按页查找商品
    * @Date 10:38 2020/4/17
    * @Param [pageNum, pageSize, goodsCategory, goodsAttributes, goodsName]
    * @return com.alibaba.fastjson.JSONObject
    **/
    @ApiOperation("按页查找商品")
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

    /**
     * @Author Wangcc
     * @Description  按id查找
     * @Date 10:38 2020/4/17
     * @Param []
     * @return com.alibaba.fastjson.JSONObject
     **/
    @ApiOperation("根据id查找商品")
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


    @ApiOperation("上传图片")
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public Result uploadImage(MultipartFile[] file){
        String path = "/admin/upload/image";
        String url = HOST+path;
        String key="file";
        try {
            JSONObject jsonObject= httpTools.uploadImage(url,key,file,null);
            if(jsonObject!=null){
                return new Result<JSONObject>().setCode(ResultCode.SUCCESS)
                        .setMessage("上传成功")
                        .setData(jsonObject);
            }else{
                return new Result<JSONObject>().setCode(ResultCode.INTERNAL_SERVER_ERROR)
                        .setMessage("上传失败")
                        .setData(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<JSONObject>().setCode(ResultCode.INTERNAL_SERVER_ERROR)
                    .setMessage("上传失败")
                    .setData(null);
        }


    }

}
