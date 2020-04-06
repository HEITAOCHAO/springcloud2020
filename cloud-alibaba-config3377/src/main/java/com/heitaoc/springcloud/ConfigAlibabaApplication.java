package com.heitaoc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/6 16:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigAlibabaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAlibabaApplication.class);
    }

}
