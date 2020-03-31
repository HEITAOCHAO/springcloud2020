package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.clinet.ProviderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 15:15
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "global")
public class ConsumerHystrixController {

    @Autowired
    private ProviderHystrixService providerHystrixService;

    @RequestMapping(value = "/hystrix/ok",method = RequestMethod.GET)
    public String providerIsOk(){
        return providerHystrixService.providerIsOk();
    }

    @RequestMapping(value = "/hystrix/timeout",method = RequestMethod.GET)
//    @HystrixCommand(fallbackMethod = "timeoutOrException",commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
////    })
    @HystrixCommand
    public String providerIsTimeout(){
        return providerHystrixService.providerIsTimeout();
    }

    private String timeoutOrException(){
        return "客户端84服务降级！";
    }

    //全局统一降级
    private String global(){
        return "全局统一降级！";
    }
}
