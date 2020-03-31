package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.entity.Payment;
import com.heitaoc.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 获取服务信息
     * @return
     */
    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("element={}",element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for(ServiceInstance instance:instances){
            log.info(instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @RequestMapping(value = "/loadbalanced",method = RequestMethod.GET)
    public String getPort(){
        return serverPort;
    }

    @RequestMapping(value = "/timeout",method = RequestMethod.GET)
    public String getTimeoutData(){
        try {
            Thread.sleep(3000);
        }catch (Exception e){
            e.getStackTrace();
        }
        return "hello world!";
    }
}
