package com.heitaoc.order.client;

import com.heitaoc.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 23:02
 */
@FeignClient("seata-account-server")
public interface AccountClient {


    @RequestMapping(value = "/account/{userId}/{money}",method = RequestMethod.PUT)
    CommonResult updateAccountMoney(@PathVariable("userId") Long userId, @PathVariable("money") Integer money);
}
