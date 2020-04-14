package com.heitaoc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/10 21:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerSentinerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSentinerApplication.class);
    }
}
