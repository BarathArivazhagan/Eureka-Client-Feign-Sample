package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class EurekaClientApp1Application {
	
	private static final Logger logger=LoggerFactory.getLogger(EurekaClientApp1Application.class);
	
	@Autowired
	private Client2Feign client;

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp1Application.class, args);
	}
	
	@GetMapping("/app2")
	public String callClient2(){
		
		if(logger.isInfoEnabled()){
			logger.info("Call Client 2  method is called");
		}
		return client.handleClient();
		
	}
	
	
}
