package com.anheng.cn.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.anheng.cn.config.MqConfig;

@Component
@RabbitListener(queues = MqConfig.queueName)
public class ReceiverMq {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RabbitHandler
	public void receiver(String message) {
		logger.info("接收到消息：" + message);
	}
}
