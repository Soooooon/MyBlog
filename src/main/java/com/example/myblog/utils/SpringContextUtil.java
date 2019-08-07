/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.example.myblog.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 一个用作搭建Spring Bean和非Spring Bean的桥梁
 * 在非SpringBean的环境中获取到一个SpringBean.
 */
@Service
@Slf4j
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext appCtx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }

    public static ApplicationContext getAppContext() {
        return appCtx;
    }

    public static Object getBean(String beanName) throws BeansException {
        return getAppContext().getBean(beanName);
    }

    public static <T> T getBean(Class<T> requiredType) throws BeansException {
        return getAppContext().getBean(requiredType);
    }


    /**
     * 获取带泛型的bean. 例如: CrudRepository<Article,Long> 那么传入参数：CrudRepository.class, Article.class, Long.class
     */
    public static Object getGenericBean(Class<?> sourceClass, Class<?>... generics) throws Exception {

        ResolvableType resolvableType = ResolvableType.forClassWithGenerics(sourceClass, generics);

        if (resolvableType != null) {
            String[] beanNames = SpringContextUtil.getAppContext().getBeanNamesForType(resolvableType);
            if (beanNames != null) {
                if (beanNames.length > 0 && beanNames[0] != null) {
                    return SpringContextUtil.getAppContext().getBean(beanNames[0]);
                } else {
                    log.error("出现数组长度为0的情况了！");
                }

            }

        }

        throw new Exception("不存在" + resolvableType.toString() + "的相关Bean,请及时排查错误！");

    }


    /**
     * 打印出所有装载了的bean
     */
    public static void printBeans() {
        System.out.print(Arrays.asList(getAppContext().getBeanDefinitionNames()));
    }

}