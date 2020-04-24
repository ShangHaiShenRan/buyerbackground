package com.hangyiyun.hangyiyun.controller.mall;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.apiresult.Result;
import com.hangyiyun.hangyiyun.apiresult.ResultCode;
import com.hangyiyun.hangyiyun.utils.*;
import com.shsr.objectvo.hangyiyun.vo.mall.TMpfMallInfo;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangcc
 * @Description 商城 添加，修改，查询
 * @Date 13:52 2020/4/5
 * @Param 
 * @return 
 **/
@RestController
@RequestMapping(value = "/Mall",produces = {"application/json;charset=UTF-8"})
public class MallController {

    final String HOST="http://xyyapi.michain.tech";

    private static final Logger logger = LoggerFactory.getLogger(MallController.class);

    private static final String tokenKey = "d811ad6ff50765b1e791318643239744";

    @Autowired
    private Util util;
    
    @Autowired
    private RedisUtil redisUtil;

    /*
     * 功能描述: <br>
     * 〈〉  商城查询接口（根据id查询）
     * @Param: id(商城id)
     * @Return:Map集合
     * @Author: 骄傲的骨傲天
     * @Date: 2020/3/29 11:39
     */
    @RequestMapping(value = "/by/id",method = RequestMethod.GET)
//    @ApiOperation("根据id查找saas商店")
    public JSONObject selectMallByID(String id){
        JSONObject result = new JSONObject();

        String path="/admin/mall/by/id";
        String url = HOST+path;

        Map<String,String> heards = new HashMap<String,String>();
        heards.put("Content-Type","application/json");
        String params = "id="+id;

        /*请求头添加数据(目前只添加一个其他用默认格式)*/

        try {

            JSONObject jsonObjResult = HttpClientUtils.doGet(url, heards, params);

            result = util.checkRespStatusAndGetMsg(jsonObjResult);

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @Author wangcc
     * @Description  新增商城
     * @Date 10:53 2020/4/3
     * @Param [mallInfo]
     * @return
     **/
    @ApiOperation("添加saas平台上面的商城")
    @RequestMapping(value = "/addMall",method = RequestMethod.POST)
    public Result<JSONObject> addMall(@RequestBody TMpfMallInfo mallInfo, @RequestHeader("Authorization") String token) throws Exception {
        String path="/admin/mall";
        String url = HOST+path;

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization",token);

        JSONObject post = util.getResultForObj(mallInfo, HOST, path, "POST", headers);
        if(post.isEmpty()){
            return new Result<JSONObject>().setCode(ResultCode.FAIL).setMessage("失败").setData(null);
        }

        boolean notBlank = StringUtils.isNotBlank(post.toString());
        if(notBlank){
            String encryptData = post.getString("data");
            boolean userMsgToRedise = redisUtil.set(mallInfo.getPhone()+"ACT",encryptData.toString() ); /*将加密数据存储到redise*/
            return new Result<JSONObject>().setCode(ResultCode.SUCCESS).setMessage("成功").setData(post);
        }else{
            return new Result<JSONObject>().setCode(ResultCode.INTERNAL_SERVER_ERROR).setMessage("失败").setData(null);
        }
    }

    /**
     * @Author wangcc
     * @Description  修改界面
     * @Date 14:08 2020/4/3
     * @Param
     * @return
     **/
    @RequestMapping(value = "/editMall",method = RequestMethod.POST)
//    @ApiOperation("修改商城信息")
    public JSONObject editMall(@RequestBody TMpfMallInfo mallInfo) {

        logger.info("进入editMall.........................................");
        logger.info(JSON.toJSONString(mallInfo));
        JSONObject result = new JSONObject();

        String path="/admin/mall/edit";
        String url = HOST+path;

        Map<String,String> headers = new HashMap<String,String>();
        headers.put("Content-Type", "application/json");

        /*进行重构将这个传输改为fegin*/
        try {
            result = util.getResultForObj(mallInfo,HOST,path,"POST",headers);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  result;
    }

    /**
     * @Author wangcc
     * @Description  删除(假删除-修改状态)
     * @Date 14:34 2020/4/3
     * @Param [mallInfo]
     * @return java.lang.String
     **/
    @RequestMapping(value = "/deleteMall",method = RequestMethod.POST)
    public String deleteMall(@RequestBody TMpfMallInfo mallInfo,HttpServletRequest req, HttpServletResponse resp){
        String path="/admin/mall/edit";
        String method = "POST";

        return null;
    }
}
