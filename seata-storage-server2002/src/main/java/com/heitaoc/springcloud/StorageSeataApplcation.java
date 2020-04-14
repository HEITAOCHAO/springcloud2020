package com.heitaoc.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:03
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.heitaoc.springcloud.dao")
public class StorageSeataApplcation {
    public static void main(String[] args) {
        SpringApplication.run(StorageSeataApplcation.class);
    }
}
