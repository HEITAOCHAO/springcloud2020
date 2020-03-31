package com.heitaoc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/28 18:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsulOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulOrderApplication.class);
    }
    @Bean
    @LoadBalanced //使用@LoadBalanced赋予负载的能力， 如果注册服务为多个，没使用此注解会报错
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
