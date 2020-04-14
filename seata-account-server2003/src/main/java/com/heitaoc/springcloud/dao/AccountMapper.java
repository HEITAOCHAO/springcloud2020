package com.heitaoc.springcloud.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:47
 */
public interface AccountMapper {

    void updateAccountMoney(@Param("userId")Long userId,@Param("money")Integer money);
}
