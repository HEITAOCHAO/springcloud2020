package com.heitaoc.order.client;

import com.heitaoc.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:20
 */
@FeignClient("seata-storage-server")
public interface StorageClient {


    @RequestMapping(value = "/storage/{productId}/{residue}",method = RequestMethod.PUT)
    CommonResult updateStorage(@PathVariable("productId") Long productId,@PathVariable("residue") Integer residue);
}
