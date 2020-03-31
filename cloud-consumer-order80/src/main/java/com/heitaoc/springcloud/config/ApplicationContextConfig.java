package com.heitaoc.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/25 20:23
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
   //@LoadBalanced //使用@LoadBalanced赋予负载的能力， 如果注册服务为多个，没使用此注解会报错
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
