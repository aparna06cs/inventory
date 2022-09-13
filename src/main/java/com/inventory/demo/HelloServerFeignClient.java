package com.inventory.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.inventory.demo.HelloServerFeignClient.HelloServerFeignClientFallback;

@FeignClient(name = "hello-server", fallback = HelloServerFeignClientFallback.class)
public interface HelloServerFeignClient {	
	
	@GetMapping("/rest/hello/server")
	String getClient();
	
	@Component
	class HelloServerFeignClientFallback implements HelloServerFeignClient {
		@Override
		public String getClient() {
			return "fall back";
		}
}

}