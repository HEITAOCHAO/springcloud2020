package com.heotaoc.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/10 20:49
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${server.port}")
    private String prot;

    @RequestMapping(value = "/{num}",method = RequestMethod.GET)
    @SentinelResource(value = "provider",fallback = "test")
    public String getProt(@PathVariable("num")int num){
        if(num==0){
            throw new RuntimeException("num不能等于0！");
        }
        return "provider:"+prot;
    }

    public String test(@PathVariable("num")int num,Throwable e){
        return "fallbackfallbackfallbackfallback";
    }

}
