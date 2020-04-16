package com.shsr.buyerbackgroundgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy        //开启网关
public class BuyerbackgroundGatewayApplication  {
    public static void main(String[] args) {
        SpringApplication.run(BuyerbackgroundGatewayApplication.class, args);
    }

}
