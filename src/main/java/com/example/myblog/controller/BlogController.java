package com.example.myblog.controller;

import com.example.myblog.entity.Article;
import com.example.myblog.entity.base.WebResult;
import com.example.myblog.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/myblog")
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


    @RequestMapping("/article/{id}")
    public WebResult<Article> getArticle(@PathVariable("id") Long id){
        WebResult<Article> webResult=new WebResult<>(blogService.queryById(id));
        return webResult;
    }

    @RequestMapping("/list")
    public List<Article> getAllArticles(){
        return blogService.queryAllArticles();
    }


    @RequestMapping("/delete/{id}")
    public Boolean deleteArticle(@PathVariable("id") Long id){
        return blogService.deleteArticle(id);
    }


    @RequestMapping("/modify")
    public WebResult<Boolean> modifyArticle(@RequestBody Article article){
        WebResult<Boolean> webResult=new WebResult<>(blogService.updateArticle(article));
        return webResult;
    }


    @RequestMapping("/create")
    public Boolean createNewArticle(HttpServletRequest request,@RequestBody Article article){
        return blogService.createArticle(article);
    }

}
