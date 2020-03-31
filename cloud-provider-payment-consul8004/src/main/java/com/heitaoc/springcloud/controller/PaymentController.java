package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.entity.Payment;
import com.heitaoc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/24 22:50
 */
@RestController
@CrossOrigin
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(method = RequestMethod.POST)
    public CommonResult create(@RequestBody Payment payment){
        return new CommonResult(200,"插入成功！"+serverPort,paymentService.create(payment));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable Long id){
        return new CommonResult(200,"查询成功！"+serverPort,paymentService.getPaymentById(id));
    }

}
