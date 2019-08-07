package com.example.myblog.service;

import com.example.myblog.entity.Article;

import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
public interface BlogService {

    Boolean deleteArticle(Long id);

    Boolean updateArticle(Article article);

    Boolean createArticle(Article article);

    Article queryById(Long id);

    List<Article> queryAllArticles();

}
