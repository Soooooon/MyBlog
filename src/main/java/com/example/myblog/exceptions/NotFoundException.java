package com.example.myblog.exceptions;

import com.example.myblog.enums.ResultCode;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 用户请求的资源不存在
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class NotFoundException extends UtilException {

    public NotFoundException() {
        super(ResultCode.NOT_FOUND);
    }

    public NotFoundException(String messagePattern, Object... arguments) {
        super(ResultCode.NOT_FOUND, messagePattern, arguments);

    }

}