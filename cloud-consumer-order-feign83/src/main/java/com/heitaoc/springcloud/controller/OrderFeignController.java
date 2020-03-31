package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.clinet.PaymentFeignService;
import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 12:50
 */
@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @RequestMapping(value = "/payment",method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){
        return paymentFeignService.create(payment);
    }

    @RequestMapping(value = "/payment/{id}",method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @RequestMapping(value = "/payment/discovery",method = RequestMethod.GET)
    public Object discovery(){
        return paymentFeignService.discovery();
    }

    @RequestMapping(value = "/payment/loadbalanced",method = RequestMethod.GET)
    public String getPort(){
        return paymentFeignService.getPort();
    }

    @RequestMapping(value = "/payment/timeout",method = RequestMethod.GET)
    public String getTimeoutData(){
        return paymentFeignService.getTimeoutData();
    }
}
