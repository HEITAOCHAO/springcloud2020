package com.heitaoc.springcloud.service;

import com.heitaoc.springcloud.entity.Payment;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/24 22:48
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
