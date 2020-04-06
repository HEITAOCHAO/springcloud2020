package com.heitaoc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/5 17:04
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveController {

    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println(port+":message   "+message.getPayload());
    }
}
