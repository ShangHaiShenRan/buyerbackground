package com.shsr.buyerbackgroundservercluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BuyerbackgroundServerClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerbackgroundServerClusterApplication.class, args);
	}

}
