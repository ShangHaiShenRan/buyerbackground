package com.shsr.buyerbackgroundhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard        //启用熔断器仪表盘
@EnableDiscoveryClient
public class BuyerbackgroundHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerbackgroundHystrixApplication.class, args);
	}

}
