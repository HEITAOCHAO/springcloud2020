package com.heitaoc.springcloud.service;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 14:12
 */
public interface ProviderHystrixService {

    String providerIsOk();

    String providerIsTimeout();

    String fuse(int i);
}
