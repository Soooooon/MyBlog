package com.example.myblog.service;

import com.example.myblog.entity.Article;
import com.example.myblog.enums.SortDirection;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
public interface BlogService {

    Integer deleteArticle(Long id);

    Integer updateArticle(Article article);

    Integer createArticle(Article article);

    Article queryById(Long id);

    Page<Article> list(
            int pageNum,
            int pageSize,
            String title,
            String content,
            SortDirection articleId,
            SortDirection articleCreateTime,
            SortDirection articleRefreshTime
    );

    List<Article> queryAllArticles();

}
