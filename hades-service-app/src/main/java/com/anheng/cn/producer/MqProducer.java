package com.anheng.cn.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqProducer{
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	/**
	 * mq发送
	 */
	public void send(String serviceId, String msg) {
		this.amqpTemplate.convertAndSend(serviceId,msg);
	}
}
