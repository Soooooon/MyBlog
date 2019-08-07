package com.example.myblog.dao;

import com.example.myblog.entity.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;

/**
 * @author 礼敖
 * @version 2019/8/2
 */
@Mapper
public interface ArticleMapper {


    @Delete("delete from t_article where id=#{id}")
    boolean deleteById(Long id);

    @Update("update t_article " +
            "set " +
            "title=#{title},content=#{content},create_time=#{createTime}," +
            "refresh_time=#{refreshTime}" +
            "where id=#{id}")
    boolean update(Long id,
               String title,
               String content,
               Date createTime,
               Date refreshTime);

    @Insert("insert into t_article " +
            "(author,title,content,create_time,refresh_time) " +
            "values " +
            "(#{author},#{title},#{content},#{createTime},#{refreshTime})")
    boolean insert(String author,
                   String title,
                   String content,
                   Date createTime,
                   Date refreshTime);

    @Select("select * from t_article where id=#{id}")
    Article queryById(Long id);

    @Select("select * from t_article")
    List<Article> queryAll();

}
