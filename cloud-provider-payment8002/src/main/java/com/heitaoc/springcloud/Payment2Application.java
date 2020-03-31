package com.heitaoc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.heitaoc.springcloud.dao")
public class Payment2Application {
    public static void main(String[] args) {
        SpringApplication.run(Payment2Application.class);
    }
}
