package com.heitaoc.springcloud.handler;

import com.heitaoc.springcloud.entity.CommonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/11 23:25
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public CommonResult getExce(Exception e){
        return new CommonResult(500,"系统出错！");
    }
}
