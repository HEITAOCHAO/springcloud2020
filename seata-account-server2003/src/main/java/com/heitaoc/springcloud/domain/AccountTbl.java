package com.heitaoc.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 22:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountTbl {

    private Long id;
    private Long userId;
    private Long total;
    private Long used;
    private Long residue;

}
