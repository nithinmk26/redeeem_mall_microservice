package com.mindtree.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableHystrix
public class OrderingServiceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderingServiceApplication.class);


	public static void main(String[] args) {
		logger.info("-->Ordering service successfully updated");
		SpringApplication.run(OrderingServiceApplication.class, args);
	}

}
