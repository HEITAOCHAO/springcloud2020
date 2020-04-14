package com.heitaoc.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 21:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTbl {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private Integer money;
    private Integer status;

}
