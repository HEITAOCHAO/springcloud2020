package com.heitaoc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/26 22:08
 */
@SpringBootApplication
@MapperScan("com.heitaoc.springcloud.dao")
@EnableDiscoveryClient
public class ZKPaymentApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZKPaymentApplication.class);
    }
}
