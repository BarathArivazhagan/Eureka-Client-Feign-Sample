package com.barath.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApp2Application {
	
	private static final Logger logger=LoggerFactory.getLogger(EurekaClientApp2Application.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApp2Application.class, args);
	}
	
	@GetMapping("/handleClient")
	public String handleClient(){
		if(logger.isInfoEnabled()){
			logger.info("Client 2 handler method is called");
		}
		return "Response from Client 2";
	}
}
