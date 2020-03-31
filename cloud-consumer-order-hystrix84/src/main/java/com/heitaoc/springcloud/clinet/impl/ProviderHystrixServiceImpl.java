package com.heitaoc.springcloud.clinet.impl;

import com.heitaoc.springcloud.clinet.ProviderHystrixService;
import org.springframework.stereotype.Component;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/29 20:00
 */
@Component
public class ProviderHystrixServiceImpl implements ProviderHystrixService {
    @Override
    public String providerIsOk() {
        return "?????????????????????????????????";
    }

    @Override
    public String providerIsTimeout() {
        return null;
    }
}
