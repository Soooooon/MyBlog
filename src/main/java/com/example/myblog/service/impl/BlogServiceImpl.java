package com.example.myblog.service.impl;

import com.example.myblog.dao.ArticleMapper;
import com.example.myblog.entity.Article;
import com.example.myblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Service
public class BlogServiceImpl implements BlogService {

    private ArticleMapper articleMapper;

    @Autowired
    public BlogServiceImpl(ArticleMapper articleMapper){
        this.articleMapper=articleMapper;
    }

    @Override
    public Boolean deleteArticle(Long id) {
        return articleMapper.deleteById(id);
    }

    @Override
    public Boolean updateArticle(Article article) {
        Long id=article.getId();
        String title=article.getTitle();
        String content=article.getContent();
        Date createTime=article.getCreateTime()==null?new Date():article.getCreateTime();
        Date refreshTime=article.getRefreshTime()==null?new Date():article.getRefreshTime();
        return articleMapper.update(id,title,content,createTime,refreshTime);
    }

    @Override
    public Boolean createArticle(Article article) {
        String author=article.getAuthor();
        String title=article.getTitle();
        String content=article.getContent();
        Date createTime=article.getCreateTime();
        Date refreshTime=article.getRefreshTime();
        return articleMapper.insert(author, title, content,createTime,refreshTime);
    }

    @Override
    public Article queryById(Long id) {
        return articleMapper.queryById(id);
    }

    @Override
    public List<Article> queryAllArticles() {
        return articleMapper.queryAll();
    }
}
