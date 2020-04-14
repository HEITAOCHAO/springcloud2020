package com.heitaoc.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageTbl {

    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;

}
