package com.example.myblog.entity.base;

import lombok.Data;

import java.util.Date;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
@Data
public class BaseEntity {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime=new Date();

    /**
     * 修改时间
     */
    private Date refreshTime=new Date();

}
