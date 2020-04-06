package com.heitaoc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/6 16:16
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerAlibabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerAlibabaApplication.class);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
