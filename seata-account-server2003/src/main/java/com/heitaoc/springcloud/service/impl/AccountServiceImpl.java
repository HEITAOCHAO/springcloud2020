package com.heitaoc.springcloud.service.impl;

import com.heitaoc.springcloud.dao.AccountMapper;
import com.heitaoc.springcloud.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:51
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void updateAccountMoney(Long userId, Integer money) {
        accountMapper.updateAccountMoney(userId,money);
    }
}
