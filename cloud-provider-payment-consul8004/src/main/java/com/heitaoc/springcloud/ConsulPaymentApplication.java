package com.heitaoc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/28 18:37
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.heitaoc.springcloud.dao")
public class ConsulPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsulPaymentApplication.class);
    }
}
