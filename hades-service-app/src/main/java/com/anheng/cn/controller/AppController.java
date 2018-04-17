package com.anheng.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anheng.cn.producer.MqProducer;
import com.anheng.cn.service.AppService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AppController {
	@Autowired
	private AppService appService;
	 @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Value("${hello}")
    String hello;
    
    
    @RequestMapping(value = "/hello")
    public String hello() throws Exception{
    	return appService.sayHello();
    }
    
}
