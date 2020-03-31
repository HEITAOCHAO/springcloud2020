package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/25 20:22
 */
@RestController
@CrossOrigin
@RequestMapping("/consumer")
public class OrderController {

    //    private final String PAYMENT_URL="http://localhost:8001/payment";
    private final String PAYMENT_URL = "http://cloud-payment-service/payment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
    }
}
