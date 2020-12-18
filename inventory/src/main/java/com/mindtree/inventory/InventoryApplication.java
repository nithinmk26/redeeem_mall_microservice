package com.mindtree.inventory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(InventoryApplication.class);


	public static void main(String[] args) {
		logger.info("-->Inventory Application Started SuccessFully..!");
		SpringApplication.run(InventoryApplication.class, args);
	}

}
