package com.example.myblog.controller.base;

import com.example.myblog.entity.base.BaseEntity;
import com.example.myblog.exceptions.UtilException;
import lombok.Getter;
import lombok.Setter;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
public abstract class BaseEntityForm<E extends BaseEntity> {

    @Getter
    @Setter
    protected Long id;

    // 是否为编辑模式
    protected boolean createMode=false;

    private Class<E> clazz;

    public BaseEntityForm(Class<E> clazz){
        this.clazz=clazz;
    }

    protected abstract void preCheck(E entity);


    public E create(){
        this.createMode=true;

        E entity;
        try {
            //创建一个空的实体
            entity=clazz.newInstance();
        } catch (Exception e) {
            throw new UtilException("构建实体时出错");
        }

        // 将form内容放入entity中
        this.preCheck(entity);

        return entity;
    }






}
