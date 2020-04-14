package com.heitaoc.order.dao;

import com.heitaoc.order.domain.OrderTbl;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 21:08
 */
public interface OrderMapper {

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
    void updateOrderStatus(@Param("userId")Long userId,@Param("status")Integer status);
}
