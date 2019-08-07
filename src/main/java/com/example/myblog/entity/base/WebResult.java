package com.example.myblog.entity.base;

import com.example.myblog.enums.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Data
@NoArgsConstructor
public class WebResult<T> {
    private ResultCode code = ResultCode.OK;
    private T data;
    private String msg = "success";

    public WebResult(ResultCode code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public WebResult(ResultCode code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public WebResult(T data) {
        this.data = data;
    }
}
