package com.heitaoc.springcloud.service;


/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:11
 */
public interface IStorageService {

    /**
     * 修改库存
     * @param productId
     * @param residue
     */
    void updateStorage(Long productId, Integer residue);
}
