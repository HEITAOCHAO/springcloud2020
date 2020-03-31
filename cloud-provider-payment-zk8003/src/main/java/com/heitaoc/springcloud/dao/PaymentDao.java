package com.heitaoc.springcloud.dao;

import com.heitaoc.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/24 22:26
 */
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
