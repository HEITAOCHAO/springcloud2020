package com.heitaoc.springcloud.lb.impl;

import com.heitaoc.springcloud.lb.ILoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: 郭超
 *
 *      自定义轮询算法
 *
 * @DateTime: 2020/3/28 21:16
 */
@Component
public class LoadBalancedImpl implements ILoadBalanced {

    //原子整数
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    private final int getInt(){
        int cur;
        int next;
        do{
            cur =this.atomicInteger.get();
            next=cur>=200000000?0:cur+1;
        }while (!this.atomicInteger.compareAndSet(cur,next));
        System.out.println("next==="+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> instances) {

        return instances.get( getInt()%instances.size());
    }
}
