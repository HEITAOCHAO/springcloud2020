package com.heitaoc.springcloud.service.impl;

import com.heitaoc.springcloud.dao.PaymentDao;
import com.heitaoc.springcloud.entity.Payment;
import com.heitaoc.springcloud.service.PaymentService;
import com.heitaoc.springcloud.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 郭超
 * @DateTime: 2020/3/24 22:48
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        payment.setId(new IdWorker(1,1).nextId());
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
