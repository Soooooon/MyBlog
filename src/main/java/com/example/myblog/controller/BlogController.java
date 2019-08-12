package com.example.myblog.controller;

import com.example.myblog.controller.base.BaseController;
import com.example.myblog.entity.Article;
import com.example.myblog.entity.base.WebResult;
import com.example.myblog.enums.ResultCode;
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
public class BlogController extends BaseController {

    private BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService){
        this.blogService=blogService;
    }


    @RequestMapping("/")
    public WebResult<String> check(){
        return success(ResultCode.OK, "测试登陆");

//        WebResult<String> webResult=new WebResult<>("测试登陆");
//        return webResult;
    }

//    @RequestMapping("/login")
//    public WebResult<?> login(@RequestParam String username,@RequestParam String password){
//
//        Boolean flag=username.equals("root")&&password.equals("admin")?true:false;
//        WebResult<Boolean> webResult=new WebResult<>(flag);
//        return webResult;
//    }


    @RequestMapping("/detail/{id}")
    public WebResult<Article> getArticle(@PathVariable("id") Long id){
        Article article=blogService.queryById(id);
        return success(article);

//        WebResult<Article> webResult=new WebResult<>(blogService.queryById(id));
//        return webResult;
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

        return success(page);

//        WebResult<Page> webResult=new WebResult<>(page);
//        return webResult;
    }


    @RequestMapping("/delete/{id}")
    public WebResult deleteArticle(@PathVariable("id") Long id){
        Integer res=blogService.deleteArticle(id);
        return success(res);
    }


    @RequestMapping("/edit")
    public WebResult<Integer> modifyArticle(ArticleForm articleForm) throws Exception {
        Article article=articleForm.update();
        Integer res=blogService.updateArticle(article);
        return success(res);

//        WebResult<Integer> webResult=new WebResult<>(blogService.updateArticle(article));
//        return webResult;
    }


    @RequestMapping("/create")
    public WebResult<Integer> createNewArticle(ArticleForm articleForm){
        Article article=articleForm.create();
        Integer res=blogService.createArticle(article);
        return success(res);

//        return blogService.createArticle(article);
//        return success(article);
    }

    @RequestMapping("/queryall")
    public WebResult<List<Article>> queryAll(){
        List<Article> articles=blogService.queryAllArticles();
//        WebResult<List<Article>> webResult=new WebResult<>(articles);
//        return webResult;
        return success(articles);
    }

}
