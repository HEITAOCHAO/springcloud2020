package com.heotaoc.springcloud.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 郭超
 * @DateTime: 2020/4/10 22:05
 */
@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String error(Exception e){
        return "统一处理异常类！"+e.getMessage();
    }
}
