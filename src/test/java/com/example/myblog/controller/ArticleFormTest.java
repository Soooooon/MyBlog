package com.example.myblog.controller;

import com.example.myblog.entity.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 礼敖
 * @version 2019/8/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleFormTest {


    private ArticleForm articleForm=new ArticleForm();

    @Before
    public void beforeTest(){
        articleForm.setAuthor("leon");
        articleForm.setTitle("a title");
        articleForm.setContent("a content");
    }

    @Test
    public void testFind() throws Exception {
        Article article=articleForm.find(1);

        System.out.println(article.getAuthor());
    }



}