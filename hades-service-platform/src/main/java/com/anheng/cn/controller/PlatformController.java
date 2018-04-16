package com.anheng.cn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class PlatformController {
	@Value("${hello}")
	private String hello;
	
	@RequestMapping("/helloApi")
	@HystrixCommand(fallbackMethod = "backError")
	public String helloApi() {
		return this.hello;
	}
	
    public String backError() {
    	return "platform处理错误";
    }
}
