package com.heitaoc.springcloud.controller;

import com.heitaoc.springcloud.entity.CommonResult;
import com.heitaoc.springcloud.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:13
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private IStorageService storageService;

    @RequestMapping(value = "/{productId}/{residue}",method = RequestMethod.PUT)
    public CommonResult updateStorage(@PathVariable("productId") Long productId,@PathVariable("residue") Integer residue){
        storageService.updateStorage(productId,residue);
        return new CommonResult(200,"修改成功");
    }
}
