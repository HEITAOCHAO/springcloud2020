package com.heitaoc.springcloud.service.impl;

import com.heitaoc.springcloud.dao.StorageMapper;
import com.heitaoc.springcloud.service.IStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:12
 */
@Service
@Transactional
public class StorageServiceImpl implements IStorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void updateStorage(Long productId, Integer residue) {
        storageMapper.updateStorage(productId, residue);
    }
}
