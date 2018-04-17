package com.anheng.cn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anheng.cn.producer.MqProducer;
import com.anheng.cn.service.AppService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class AppServiceImpl implements AppService {
	@Autowired
	private MqProducer mqProducer;
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	@HystrixCommand(fallbackMethod = "backError")
	public String sayHello() throws Exception {
		try {
	    	mqProducer.send("hello", "hello,mq");
	    	String back = restTemplate.getForObject("http://localhost:9902/helloApi",String.class);
	    	return back;
		}catch(Exception e) {
			throw new Exception();
		}
	}
	
    private String backError() {
    	return "发送mq消息错误";
    }
}
