package com.heitaoc.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/7 21:43
 */
@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @RequestMapping(value = "/getA",method = RequestMethod.GET)
    public String getA(){
        return "AAAAAAAA";
    }


    @RequestMapping(value = "/getB",method = RequestMethod.GET)
    public String getB(){
        return "BBBBBBBB";
    }
}
