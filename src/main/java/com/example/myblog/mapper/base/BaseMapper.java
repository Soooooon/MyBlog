package com.example.myblog.mapper.base;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
public interface BaseMapper<T> {

    /**
     * 插入一个对象
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 按id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 更新 返回影响的条数
     * @param t
     * @return
     */
    int update(T t);

    /**
     * 按id查询
     * @param id
     * @return
     */
    T selectById(Long id);

}
