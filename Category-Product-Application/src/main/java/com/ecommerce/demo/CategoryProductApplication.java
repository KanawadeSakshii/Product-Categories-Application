package com.ecommerce.demo;
/**
  
 * 
  @author: Kanawade Sakshii 
 * 
  
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CategoryProductApplication {

	private static final Logger logger=LoggerFactory.getLogger(CategoryProductApplication.class);
	public static void main(String[] args) {
		logger.info("Application Started ");
		SpringApplication.run(CategoryProductApplication.class, args);
	}

}
