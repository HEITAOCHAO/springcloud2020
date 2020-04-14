package com.heitaoc.springcloud.dao;

import org.apache.ibatis.annotations.Param;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:07
 */
public interface StorageMapper {

    void updateStorage(@Param("productId")Long productId,@Param("residue")Integer residue);
}
