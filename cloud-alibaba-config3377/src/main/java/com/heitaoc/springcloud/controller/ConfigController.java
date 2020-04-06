package com.heitaoc.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/6 16:18
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @Value("${str.info}")
    private String info;

    @RequestMapping(value = "/port",method = RequestMethod.GET)
    public String findPort(){
        return "端口号："+port;
    }

    @RequestMapping(value = "/str",method = RequestMethod.GET)
    public String findString(){
        return "信息："+info;
    }

}
