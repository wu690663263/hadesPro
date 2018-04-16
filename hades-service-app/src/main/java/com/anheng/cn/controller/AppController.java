package com.anheng.cn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anheng.cn.producer.MqProducer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class AppController {

	@Autowired
	private MqProducer mqProducer;
	@Autowired
	private RestTemplate restTemplate;
	 @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Value("${hello}")
    String hello;
    
    @HystrixCommand(fallbackMethod = "backError")
    @RequestMapping(value = "/hello")
    public String hello() throws Exception{
    	try {
        	mqProducer.send("hello", "hello,mq");
        	String back = restTemplate.getForObject("http://localhost:9902/helloApi",String.class);
        	return back;
    	}catch(Exception e) {
    		throw new Exception();
    	}

    }
    
    public String backError() {
    	return "发送mq消息错误";
    }
}
