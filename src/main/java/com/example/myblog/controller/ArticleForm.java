package com.example.myblog.controller;

import com.example.myblog.controller.base.BaseEntityForm;
import com.example.myblog.entity.Article;
import com.example.myblog.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
public class ArticleForm extends BaseEntityForm<Article> {

    @Size(min = 1,max = 50)
    private String author;

    @Size(min = 1,max = 100)
    private String title;

    @Size(min = 1,max = 200)
    private String content;

    @NotNull
    @DateTimeFormat(pattern = DateUtil.DEFAULT_FORMAT)
    private Date createTime;

    @NotNull
    @DateTimeFormat(pattern = DateUtil.DEFAULT_FORMAT)
    private Date refreshTime;

    public ArticleForm() {
        super(Article.class);
    }

    @Override
    protected void preCheck(@NotNull Article article) {
        article.setTitle(title);
        article.setContent(content);
        article.setRefreshTime(new Date());

        if (this.createMode){
            article.setCreateTime(new Date());
            article.setAuthor(author);
        }

    }
}
