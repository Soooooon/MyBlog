package com.example.myblog.service.impl;

import com.example.myblog.mapper.ArticleMapper;
import com.example.myblog.entity.Article;
import com.example.myblog.enums.SortDirection;
import com.example.myblog.service.BlogService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Service
public class BlogServiceImpl implements BlogService {

    private ArticleMapper articleMapper;

    @Autowired(required = false)
    public BlogServiceImpl(ArticleMapper articleMapper){
        this.articleMapper=articleMapper;
    }

    @Override
    public Integer deleteArticle(Long id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public Integer updateArticle(Article article) {
        return articleMapper.update(article);
    }

    @Override
    public Integer createArticle(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public Article queryById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public Page<Article> list(int pageNum, int pageSize, String title, String content, SortDirection articleId, SortDirection articleCreateTime, SortDirection articleRefreshTime) {
        Page<Article> page=articleMapper.page(pageNum, pageSize, title, content, articleId, articleCreateTime,
                articleRefreshTime);

        return page;
    }


    @Override
    public List<Article> queryAllArticles() {
        return articleMapper.queryAll();
    }
}
