package com.heitaoc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/5 17:00
 */
@SpringBootApplication
@EnableEurekaClient
public class SendMessageApplication {
    public static void main(String[] args) {
        SpringApplication.run(SendMessageApplication.class);
    }
}
