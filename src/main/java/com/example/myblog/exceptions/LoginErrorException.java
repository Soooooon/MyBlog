package com.example.myblog.exceptions;

import com.example.myblog.enums.ResultCode;
import lombok.Data;
import lombok.Getter;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Data
public class LoginErrorException extends RuntimeException {

    private ResultCode code;
    private String message;

    public LoginErrorException(ResultCode code){
        this.code=code;
        this.message=code.getMessage();
    }

}
