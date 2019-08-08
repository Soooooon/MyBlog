package com.example.myblog.mapper;

import com.example.myblog.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleMapperTest {

    @Autowired(required = false)
    private ArticleMapper articleMapper;




    @Test
    public void queryAll(){
        List<Article> articles=articleMapper.queryAll();

        System.out.println(articles.size());

    }
}