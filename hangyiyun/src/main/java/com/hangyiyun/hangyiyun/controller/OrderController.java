package com.hangyiyun.hangyiyun.controller;

import com.alibaba.fastjson.JSONObject;
import com.hangyiyun.hangyiyun.annotation.AuthToken;
import com.hangyiyun.hangyiyun.utils.HttpUtils;
import com.hangyiyun.hangyiyun.utils.StringUtils;
import com.hangyiyun.hangyiyun.utils.Util;
import com.shsr.objectvo.vo.order.Order;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangcc
 * @Description //TODO 订单：增删改查，添加token
 * @Date 0:56 2020/4/4
 * @Param
 * @return
 **/
@RestController
@RequestMapping("/Order")
public class OrderController {

    final String HOST = "http://xyyapi.michain.tech";

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private Util util;

    /**
     * @return java.lang.String
     * @Author wangcc
     * @Description //TODO 添加订单，验证token
     * @Date 0:59 2020/4/4
     * @Param [order]
     **/
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @AuthToken
    public JSONObject addOrder(@RequestBody Order order, @RequestHeader("Authorization") String token) {
        logger.info("打印传入的内容" + order.getCityCode());

        JSONObject result = new JSONObject();

        String path = "/mapi/add/order";
        String url = HOST + path;
        String method = "POST";

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        /*不能从redis中获取token，能到这步说明就直接将头中的token传入*/
        logger.info("toke:" + token.toString());
        if (StringUtils.isNotBlank(token)) {
            headers.put("Authorization", token);
            //result = util.getResultForObj(order,url,method,headers);
        }

        return result;
    }


    /**
     * @return com.alibaba.fastjson.JSONObject
     * @Author wangcc
     * @Description //TODO 查询订单(GET请求) 验证token
     * @Date 12:20 2020/4/4
     * @Param []
     **/
    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    @AuthToken
    public JSONObject getOrderBy(@RequestParam String pageNum, String pageSize, String type,@RequestHeader("Authorization") String token) {

        logger.info("***************************************************************");

        String path = "/admin/get-distribution-order";
        String url = HOST+path;

        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> heard = new HashMap<String, String>();

        JSONObject result = new JSONObject();

        logger.info("打印token内容"+token);

        if(!StringUtils.isNotBlank(token)){
            result.put("status","false");
            result.put("Message","Invalid account, please reLogin");
            return result;
        }

        //heard.put("Content-Type","application/x-w   ww-form-urlencoded; charset=UTF-8");
        heard.put("Content-Type","application/json; charset=UTF-8");
        heard.put("Authorization",token);

        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        params.put("type",type);
        params.put("token",token);

        try {
            //HttpResponse response = (HttpResponse) HttpUtils.doGet(HOST, path, method, heard, params);
            HttpResponse response = HttpUtils.doGet(HOST, path, "", heard, params);

            //获取response的body
            result = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /*/**
     * @Author Wangcc
     * @Description //TODO POST 查询订单
     * @Date 10:40 2020/4/17
     * @Param [paymentWay, selectTime, startTime, endTime, selectDetail, details, orderStatus, pageNum, pageSize, token]
     * @return com.alibaba.fastjson.JSONObject
     **/
    @RequestMapping(value = "/getOrderByPost", method = RequestMethod.POST)
    @AuthToken
    public JSONObject getOrderByPost(@RequestBody String paymentWay,String selectTime,String startTime,String endTime,String selectDetail,String details,String orderStatus,String pageNum,String pageSize,@RequestHeader("Authorization") String token){
        JSONObject result = new JSONObject();

        String path = "/admin/search/dis/order";

        Map<String, String> params = new HashMap<String, String>();
        Map<String, String> heard = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();

        heard.put("Content-Type","application/json; charset=UTF-8");
        heard.put("Authorization",token);

        bodys.put("paymentWay",paymentWay);
        bodys.put("selectTime",selectTime);
        bodys.put("startTime",startTime);
        bodys.put("endTime",endTime);
        bodys.put("selectDetail",selectDetail);
        bodys.put("details",details);
        bodys.put("orderStatus",orderStatus);
        bodys.put("pageNum",pageNum);
        bodys.put("pageSize",pageSize);

        try {
            HttpResponse response = HttpUtils.doPost(HOST,path,"",heard,params,bodys);

            /*获得里面的内容*/
            result = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
