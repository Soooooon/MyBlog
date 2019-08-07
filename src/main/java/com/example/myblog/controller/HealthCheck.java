package com.example.myblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@RestController
public class HealthCheck {

    @RequestMapping("/health")
    public String check(){
        return "health";
    }

}
