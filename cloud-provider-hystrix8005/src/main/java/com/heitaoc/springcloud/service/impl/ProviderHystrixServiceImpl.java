package com.heitaoc.springcloud.service.impl;

import com.heitaoc.springcloud.service.ProviderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 14:13
 */
@Service
public class ProviderHystrixServiceImpl implements ProviderHystrixService {

    @Override
    public String providerIsOk() {
        return "正常连接！";
    }

    /**
     * 服务降级
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "timeoutOrException",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String providerIsTimeout() {
        int timeout=5;
        try {
            Thread.sleep(timeout*1000);
        }catch (Exception e){
            e.getStackTrace();
        }
        return "连接超时： "+timeout+" 秒！";
    }

    private String timeoutOrException(){
        return "服务降级！";
    }

    /**
     * 服务器熔断
     * @param i
     * @return
     */
    @Override
    @HystrixCommand(fallbackMethod = "fuseFuseFuse",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"), //短路多久以后开始尝试是否恢复
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String fuse(int i){
        if(i<0){
            throw new RuntimeException("i小于0");
        }
        return UUID.randomUUID().toString().replace("-","");
    }
    private String fuseFuseFuse(int i){
        return "服务熔断！"+i;
    }
}
