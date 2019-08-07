package com.example.myblog.entity;

import com.example.myblog.entity.base.BaseEntity;
import lombok.Data;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Data
public class Article extends BaseEntity {

    /**
     * 作者
     */
    private String author;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;
}
