package com.heitaoc.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/9 21:45
 */
public class CustomerBlockHandler {

    public static String one(BlockException e){
        return "one   exception";
    }

    public static String tow(BlockException e){
        return "tow   exception";
    }
}
