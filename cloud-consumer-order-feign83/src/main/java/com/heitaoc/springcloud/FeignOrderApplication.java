package com.heitaoc.springcloud;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 12:33
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderApplication.class);
    }

    /**
     * feign 日志打印级别  NONE, BASIC, HEADERS, FULL;
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
