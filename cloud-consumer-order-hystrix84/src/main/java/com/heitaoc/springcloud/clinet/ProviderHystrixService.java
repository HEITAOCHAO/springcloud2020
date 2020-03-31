package com.heitaoc.springcloud.clinet;

import com.heitaoc.springcloud.clinet.impl.ProviderHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 15:13
 */
@FeignClient(value = "cloud-provider-hystrix-service",fallback = ProviderHystrixServiceImpl.class)
public interface ProviderHystrixService {

    @RequestMapping(value = "/hystrix/ok",method = RequestMethod.GET)
    String providerIsOk();

    @RequestMapping(value = "/hystrix/timeout",method = RequestMethod.GET)
    String providerIsTimeout();
}
