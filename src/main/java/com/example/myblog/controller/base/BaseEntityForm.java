package com.example.myblog.controller.base;

import com.example.myblog.mapper.base.BaseMapper;
import com.example.myblog.entity.base.BaseEntity;
import com.example.myblog.exceptions.BadRequestException;
import com.example.myblog.exceptions.NotFoundException;
import com.example.myblog.exceptions.UtilException;
import com.example.myblog.utils.SpringContextUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 礼敖
 * @version 2019/8/7
 */
public abstract class BaseEntityForm<E extends BaseEntity> {

    @Getter
    @Setter
    protected Long id=null;

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


    public E update() throws Exception {

        this.createMode=false;

        if (id==null){
            throw new BadRequestException("编辑时id必填");
        }

        E entity=this.check(this.id);

        this.preCheck(entity);

        entity.setRefreshTime(new Date());

        return entity;
    }

    /**
     * 这是一个魔法操作，可以快速获取到实体对应的Mapper.
     *
     * @return 返回实体对应的Mapper
     */
    @SuppressWarnings("unchecked")
    protected BaseMapper<E> getMapper() throws Exception {
        return (BaseMapper<E>) SpringContextUtil.getGenericBean(BaseMapper.class, this.clazz);
    }

    /**
     * 从数据库中检出一个当前泛型的实例。
     * 找不到抛异常。
     */
    public E check(long id) throws Exception {
        E e = this.find(id);
        if (e == null) {
            throw new NotFoundException("id={}对应的{}不存在", id, this.clazz.getSimpleName());
        }
        return e;
    }


    /**
     * 从数据库中找出一个当前泛型的实例。
     * 找不到返回null
     */
    public E find(long id) throws Exception {
        return this.getMapper().selectById(id);
    }


}
