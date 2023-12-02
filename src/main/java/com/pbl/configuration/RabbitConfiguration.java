package com.pbl.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 队列配置
 * */
@Configuration
public class RabbitConfiguration {
//    @Bean("courseQueue")
//    public Queue queue(){
//        return QueueBuilder
//                .durable("course")
//                .build();
//    }

}
