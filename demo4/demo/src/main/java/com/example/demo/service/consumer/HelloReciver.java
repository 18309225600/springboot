package com.example.demo.service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReciver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Reciver"+hello);
    }
}
