package com.example.myblog.exceptions;

import com.example.myblog.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 用户错误请求的异常
 * 这个异常的错误触发是用户犯的错。用户调整自己的入参，就可以消除这个错误。
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class BadRequestException extends UtilException {


    public BadRequestException() {
        super(ResultCode.BAD_REQUEST);
    }

    public BadRequestException(String messagePattern, Object... arguments) {
        super(ResultCode.BAD_REQUEST, messagePattern, arguments);
    }

    public BadRequestException(ResultCode resultCode) {
        super(resultCode);
    }


}