package com.heitaoc.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/28 20:07
 */

/**
 * Ribbon 自定义策略
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();  //随机
    }
}
