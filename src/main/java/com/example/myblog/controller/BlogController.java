package com.example.myblog.controller;

import com.example.myblog.entity.Article;
import com.example.myblog.entity.base.WebResult;
import com.example.myblog.enums.SortDirection;
import com.example.myblog.service.BlogService;
import com.github.pagehelper.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Slf4j
//@CrossOrigin
@RestController
@RequestMapping("/api/article")
public class BlogController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService){
        this.blogService=blogService;
    }


    @RequestMapping("/")
    public WebResult<String> check(){
        WebResult<String> webResult=new WebResult<>("测试登陆");
        return webResult;
    }

    @RequestMapping("/login")
    public WebResult<?> login(@RequestParam String username,@RequestParam String password){

        Boolean flag=username.equals("root")&&password.equals("admin")?true:false;
        WebResult<Boolean> webResult=new WebResult<>(flag);
        return webResult;
    }


    @RequestMapping("/detail/{id}")
    public WebResult<Article> getArticle(@PathVariable("id") Long id){
        WebResult<Article> webResult=new WebResult<>(blogService.queryById(id));
        return webResult;
    }

    @RequestMapping("/list")
    public WebResult<Page> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "20") int pageSize,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) SortDirection articleId,
            @RequestParam(required = false) SortDirection articleCreateTime,
            @RequestParam(required = false) SortDirection articleRefreshTime
    ){
        Page<Article> page=blogService.list(pageNum, pageSize, title, content, articleId, articleCreateTime,
                articleRefreshTime);

        WebResult<Page> webResult=new WebResult<>(page);
        return webResult;
    }


    @RequestMapping("/delete/{id}")
    public Integer deleteArticle(@PathVariable("id") Long id){
        return blogService.deleteArticle(id);
    }


    @RequestMapping("/edit")
    public WebResult<Integer> modifyArticle(ArticleForm articleForm) throws Exception {
        Article article=articleForm.update();
        WebResult<Integer> webResult=new WebResult<>(blogService.updateArticle(article));
        return webResult;
    }


    @RequestMapping("/create")
    public Integer createNewArticle(ArticleForm articleForm){
        Article article=articleForm.create();
        return blogService.createArticle(article);
    }

    @RequestMapping("/queryall")
    public WebResult<List<Article>> queryAll(){
        List<Article> articles=blogService.queryAllArticles();
        WebResult<List<Article>> webResult=new WebResult<>(articles);
        return webResult;
    }

}
