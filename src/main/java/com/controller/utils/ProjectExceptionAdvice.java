package com.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {
    @ExceptionHandler
    public Result doException(Exception e) {
        e.printStackTrace();
        return new Result(Code.ERR, null, "失败");
    }
}
