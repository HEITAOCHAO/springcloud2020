package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.service.ProviderHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 14:16
 */
@RestController
@RequestMapping("/hystrix")
public class ProviderHystrixController {

    @Autowired
    private ProviderHystrixService providerHystrixService;

    @RequestMapping(value = "/ok",method = RequestMethod.GET)
    public String providerIsOk(){
        return providerHystrixService.providerIsOk();
    }

    @RequestMapping(value = "/timeout",method = RequestMethod.GET)
    public String providerIsTimeout(){
        return providerHystrixService.providerIsTimeout();
    }

    @RequestMapping(value = "/fuse/{id}",method = RequestMethod.GET)
    public String Fuse(@PathVariable("id") int id){
        return providerHystrixService.fuse(id);
    }
}
