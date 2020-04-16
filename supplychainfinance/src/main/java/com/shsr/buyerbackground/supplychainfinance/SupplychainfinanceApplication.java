package com.shsr.buyerbackground.supplychainfinance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SupplychainfinanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplychainfinanceApplication.class, args);
    }

}
