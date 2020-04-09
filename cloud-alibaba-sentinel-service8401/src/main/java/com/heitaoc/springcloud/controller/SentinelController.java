package com.heitaoc.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.heitaoc.springcloud.handler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/7 21:43
 */
@RestController
@RequestMapping("/sentinel")
@Slf4j
public class SentinelController {

    @RequestMapping(value = "/getA",method = RequestMethod.GET)
    public String getA(){
        System.out.println("=============");
        return "AAAAAAAA";
    }


    @RequestMapping(value = "/getB",method = RequestMethod.GET)
    public String getB(){
        log.warn("=========={}",Thread.currentThread().getName());
        return "BBBBBBBB";
    }

    @RequestMapping(value = "/hotkey",method = RequestMethod.GET)
    @SentinelResource(value = "hotkey",blockHandler = "HotKey_blockHandler")   //热点限流  blockHandler=兜底方法
    public String HotKey(@RequestParam(value = "p1",required = false)String p1,@RequestParam(value = "p2",required = false)String p2){
        return "hotkey!";
    }

    public String HotKey_blockHandler(String p1, String p2, BlockException exception){
        return "HotKey_blockHandlerHotKey_blockHandlerHotKey_blockHandler";
    }


    @RequestMapping(value = "/customerHandler",method = RequestMethod.GET)
    @SentinelResource(value = "customerHandler",blockHandlerClass = CustomerBlockHandler.class,blockHandler = "one")
    public String customerHandler(){
        return "hotkey!";
    }
}
