package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.lb.ILoadBalanced;
import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


/**
 * @Author: 郭超
 * @DateTime: 2020/3/25 20:22
 */
@RestController
@CrossOrigin
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    //    private final String PAYMENT_URL="http://localhost:8001/payment";
    private final String PAYMENT_URL = "http://cloud-payment-service/payment";

    @Autowired
    private RestTemplate restTemplate;


    //自己写的轮询算法
    @Autowired
    private ILoadBalanced loadBalanced;

    @Autowired
    private DiscoveryClient discoveryClient;


    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL, payment, CommonResult.class);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public CommonResult getPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/" + id, CommonResult.class);
    }

    @RequestMapping(value = "/payment/entity/{id}", method = RequestMethod.GET)
    private CommonResult testGetEntity(@PathVariable Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/" + id, CommonResult.class);
        //如果响应码在  2XX
        log.info(forEntity.getHeaders()+"\n"+forEntity.getStatusCode()+"\n"+forEntity.getStatusCodeValue());
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult(444,"操作失败！");
        }
    }

    @RequestMapping(value = "/payment/entity", method = RequestMethod.POST)
    public CommonResult<Payment> testPostEntity(@RequestBody Payment payment) {
        ResponseEntity<CommonResult> responseEntity = restTemplate.postForEntity(PAYMENT_URL, payment, CommonResult.class);
        log.info(responseEntity.getHeaders()+"\n"+responseEntity.getStatusCode()+"\n"+responseEntity.getStatusCodeValue());
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return responseEntity.getBody();
        }else{
            return new CommonResult(444,"操作失败！");
        }
    }


    @RequestMapping(value = "/payment/getPaymentPort", method = RequestMethod.GET)
    public String getPaymentPort() {

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");//获取payment服务
        if(instances==null||instances.size()==0){
            return"cloud-payment-service：服务不可用！";
        }
        ServiceInstance instances1 = loadBalanced.instances(instances);
        URI uri = instances1.getUri();
        return restTemplate.getForObject(uri+"/payment/loadbalanced",String.class);
    }
}
