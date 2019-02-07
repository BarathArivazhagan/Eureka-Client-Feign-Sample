package com.barath.app;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="eureka-client-app2")
public interface Client2Feign {
	
	@GetMapping("/handleClient")
	public String handleClient();

}
