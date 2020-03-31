package com.heitaoc.springcloud.clinet;

import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 12:37
 */
@FeignClient("cloud-payment-service")
public interface PaymentFeignService {

    @RequestMapping(value = "/payment",method = RequestMethod.POST)
    CommonResult create(@RequestBody Payment payment);

    @RequestMapping(value = "/payment/{id}",method = RequestMethod.GET)
    CommonResult getPaymentById(@PathVariable("id") Long id);

    @RequestMapping(value = "/payment/discovery",method = RequestMethod.GET)
    Object discovery();

    @RequestMapping(value = "/payment/loadbalanced",method = RequestMethod.GET)
    String getPort();

    @RequestMapping(value = "/payment/timeout",method = RequestMethod.GET)
    String getTimeoutData();
}
