package com.heitaoc.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/28 21:09
 */
public interface ILoadBalanced {

    ServiceInstance instances(List<ServiceInstance> instances);
}
