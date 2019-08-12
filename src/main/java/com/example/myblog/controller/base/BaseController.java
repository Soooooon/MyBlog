package com.example.myblog.controller.base;

import com.example.myblog.entity.base.WebResult;
import com.example.myblog.enums.ResultCode;
import com.github.pagehelper.Page;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
public class BaseController {

    /**
     * @return 成功消息
     */
    protected WebResult success() {
        return new WebResult(ResultCode.OK, "成功");
    }

    /**
     * @param message 信息
     * @return 信息结果
     */
    protected WebResult successString(String message) {
        return new WebResult(ResultCode.OK, message);
    }

    /**
     * @param code    结果码
     * @param message 消息
     * @return 结果消息
     */
    protected WebResult success(ResultCode code, String message) {
        return new WebResult(code, message);
    }


    /**
     * @param object 对象
     * @return 对象信息
     */
//    protected WebResult successObject(Object object) {
//        WebResult<Object> webResult = new WebResult<>(ResultCode.OK, "成功");
//        webResult.setData(object);
//        return webResult;
//    }

    /**
     * @param pageObj mabatis分页工具
     * @return 对象信息
     */
    protected <T> WebResult success(Page<T> pageObj) {

        Pager<T> pager = new Pager<>(pageObj.getPageNum(), pageObj.getPageSize(), pageObj.getTotal(), pageObj);

        WebResult<Object> webResult = new WebResult<>(ResultCode.OK, "成功");

        webResult.setData(pager);

        return webResult;
    }


    /**
     * @param object 基础对象
     * @return 对象信息
     */
    protected WebResult success(Object object) {
        WebResult<Object> webResult = new WebResult<>(ResultCode.OK, "成功");
        webResult.setData(object);
        return webResult;
    }

    /**
     * @param map 键值对
     * @return 键值对结果
     */
//    protected WebResult success(Map<String, Object> map) {
//        WebResult<Map<String, Object>> webResult = new WebResult<>(ResultCode.OK, "成功");
//        webResult.setData(map);
//        return webResult;
//    }

}
