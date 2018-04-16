package com.anheng.cn.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MqConfig {
    public static final String queueName = "hello" ;
    public Queue rabbitMqQueue(){
        return new Queue(queueName);
    }
}
