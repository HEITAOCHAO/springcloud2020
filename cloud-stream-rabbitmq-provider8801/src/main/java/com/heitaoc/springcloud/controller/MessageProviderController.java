package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.service.IMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/5 16:11
 */
@RestController
@RequestMapping("/message")
public class MessageProviderController {

    @Autowired
    private IMessageProviderService messageProviderService;

    @RequestMapping(value = "/send",method = RequestMethod.GET)
    public void sendMessage(){
        messageProviderService.sendMessage();
    }
}
