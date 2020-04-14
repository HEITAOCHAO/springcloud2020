package com.heitaoc.order.service;

import com.heitaoc.order.domain.OrderTbl;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 21:09
 */
public interface IOrderServer {

    /**
     * 创建订单
     * @param order
     */
    void create(OrderTbl order);

    /**
     * 修改订单状态
     * @param userId
     * @param status
     */
    void updateOrderStatus(Long userId, Integer status);
}
