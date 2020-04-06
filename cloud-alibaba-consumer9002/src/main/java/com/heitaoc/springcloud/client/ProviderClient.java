package com.heitaoc.springcloud.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/6 16:25
 */
@FeignClient("cloud-alibaba-provider")
public interface ProviderClient {

    @RequestMapping(value = "/provider",method = RequestMethod.GET)
    String findByData();
}
