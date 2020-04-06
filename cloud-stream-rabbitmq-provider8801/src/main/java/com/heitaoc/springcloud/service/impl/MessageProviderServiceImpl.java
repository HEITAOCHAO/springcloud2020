package com.heitaoc.springcloud.service.impl;

import com.heitaoc.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/5 15:59
 */
@EnableBinding(Source.class)  //定义消息的推送通道
public class MessageProviderServiceImpl implements IMessageProviderService {

    @Resource
    private MessageChannel output;  //消息发送通道

    @Override
    public String sendMessage() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        output.send(MessageBuilder.withPayload(uuid).build());
        System.out.println("uuid="+uuid);
        return null;
    }
}
