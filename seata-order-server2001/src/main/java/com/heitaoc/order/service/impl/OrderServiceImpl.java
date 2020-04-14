package com.heitaoc.order.service.impl;

import com.heitaoc.order.client.AccountClient;
import com.heitaoc.order.client.StorageClient;
import com.heitaoc.order.dao.OrderMapper;
import com.heitaoc.order.domain.OrderTbl;
import com.heitaoc.order.service.IOrderServer;
import com.heitaoc.springcloud.entity.IdWorker;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 21:10
 */
@Service
public class OrderServiceImpl implements IOrderServer {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageClient storageClient;

    @Autowired
    private AccountClient accountClient;

    @Override
    @GlobalTransactional(name = "heitaoc-create-order",rollbackFor = Exception.class)
    public void create(OrderTbl order) {
        System.out.println("================创建订单================");
        order.setId(new IdWorker(0,0).nextId());
        orderMapper.create(order);

        System.out.println("================修改仓库================");
        storageClient.updateStorage(order.getProductId(),order.getCount());


        System.out.println("================修改账户================");
        accountClient.updateAccountMoney(order.getUserId(),order.getMoney());

//        throw new RuntimeException("测试GlobalTransactional");
    }

    @Override
    public void updateOrderStatus(Long userId, Integer status) {
        orderMapper.updateOrderStatus(userId,status);
    }
}
