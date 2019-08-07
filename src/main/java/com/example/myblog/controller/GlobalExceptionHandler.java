package com.example.myblog.controller;

import com.example.myblog.entity.base.WebResult;
import com.example.myblog.exceptions.LoginErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({LoginErrorException.class})
    public WebResult handleLoginException(HttpServletRequest request,
                                          HttpServletResponse response,
                                          LoginErrorException exception){
        log.info("登陆失败");
        response.setStatus(exception.getCode().getHttpStatus().value());
        WebResult webResult=new WebResult(exception.getCode(),exception.getMessage());
        return webResult;
    }


}
