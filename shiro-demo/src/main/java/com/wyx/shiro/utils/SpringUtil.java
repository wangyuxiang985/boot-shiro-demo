package com.wyx.shiro.utils;

import javafx.application.Application;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @ClassName SpringUtil
 * @Description Spring上下文工具类
 * @Author yuxiang
 * @Date 2020/1/13
 * @Version 1.0
 **/
@Component
public class SpringUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     *Spring在bean初始化后会判断是不是ApplicationContextAware的子类
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 通过指定类型返回指定的Bean
     */
    public static <T> T getBean(Class<T> tClass) {
        return context.getBean(tClass);
    }
}
