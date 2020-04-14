package com.heitaoc.springcloud.service;


/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:50
 */
public interface IAccountService {

    /**
     * 修改账户余额
     * @param userId
     * @param money
     */
    void updateAccountMoney(Long userId, Integer money);
}
