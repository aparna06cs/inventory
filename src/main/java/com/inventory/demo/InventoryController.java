package com.inventory.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/inventory")
public class InventoryController {

	@Autowired
	private HelloServerFeignClient feignclient;
	
	@GetMapping("/test")
    public String hello() {
		 return "Inventory Controller";
    } 
	
	@GetMapping
    public String hello1() {
		
		 return feignclient.getClient()+":::: from inventory";
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }
}
