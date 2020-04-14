package com.heitaoc.order.controller;

import com.heitaoc.order.domain.OrderTbl;
import com.heitaoc.order.service.IOrderServer;
import com.heitaoc.springcloud.entity.CommonResult;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 21:10
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderServer orderServer;

    @RequestMapping(method = RequestMethod.POST)
    public CommonResult creat(@RequestBody OrderTbl order) {
        orderServer.create(order);
        return new CommonResult(200,"创建成功！");
    }

    @RequestMapping(value = ("/{userId}/{status}"),method = RequestMethod.PUT)
    public CommonResult updateOrderStatus(@PathVariable("userId") Long userId, @PathVariable("status") Integer status) {
        orderServer.updateOrderStatus(userId,status);
        return new CommonResult(200,"创建成功！");
    }

}
