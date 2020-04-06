package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.client.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/6 16:18
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Value("${provider.path}")
    private String path;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProviderClient providerClient;

    @RequestMapping(value = "/ribbon")
    public String findByRibbon(){
        return restTemplate.getForObject(path+"/provider",String.class);
    }

    @RequestMapping(value = "/feign")
    public String findByFeign(){
        return providerClient.findByData();
    }

}
