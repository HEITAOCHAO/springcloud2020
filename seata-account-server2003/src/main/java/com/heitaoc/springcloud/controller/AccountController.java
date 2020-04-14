package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:52
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @RequestMapping(value = "/{userId}/{money}",method = RequestMethod.PUT)
    public CommonResult updateAccountMoney(@PathVariable("userId") Long userId,@PathVariable("money") Integer money){
        accountService.updateAccountMoney(userId,money);
        return new CommonResult(200,"修改账户余额成功！");
    }
}
