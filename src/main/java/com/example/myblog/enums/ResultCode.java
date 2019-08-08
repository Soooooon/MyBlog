package com.example.myblog.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
public enum  ResultCode {

    OK(HttpStatus.OK,"成功"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "请求不合法"),
    LOGIN_ERROR(HttpStatus.BAD_REQUEST,"登陆失败"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "内容不存在"),
    UNKNOWN(HttpStatus.INTERNAL_SERVER_ERROR, "服务器未知错误");

    @Getter
    private HttpStatus httpStatus;

    @Getter
    private String message;

    ResultCode(HttpStatus httpStatus,String message){
        this.httpStatus=httpStatus;
        this.message=message;
    }

}
