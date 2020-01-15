package com.wyx.shiro.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TypeTransUtil
 * @Description 实体类型转换
 * @Author yuxiang
 * @Date 2019/12/13
 * @Version 1.0
 **/
@Slf4j
public class TypeTransUtil {


    /**
     * @Author yuxiang
     * @Description 将entityList转换成modelList
     * @Date 2019/12/13
     * @Param [fromList, tClass]
     * @return java.util.List<T>
    **/
    public static<F,T> List<T> entityListToModelList(List<F> fromList, Class<T> tClass){
        log.debug("entityListToModelList : List<Entity>属性的值赋值到List<Model>");
        if(CollectionUtils.isEmpty(fromList)){
            return null;
        }
        List<T> tList = new ArrayList<>();
        for(F f : fromList){
            T t = entityToModel(f, tClass);
            tList.add(t);
        }
        return tList;
    }

    /**
     * @Author yuxiang
     * @Description 将entity转换成model
     * @Date 2019/12/13
     * @Param [entity, modelClass]
     * @return T
    **/
    public static<F,T> T entityToModel(F entity, Class<T> modelClass) {
        log.debug("entityToModel : Entity属性的值赋值到Model");
        Object model = null;
        if (entity == null || modelClass ==null) {
            return null;
        }

        try {
            model = modelClass.newInstance();
        } catch (InstantiationException e) {
            log.error("entityToModel : 实例化异常", e);
        } catch (IllegalAccessException e) {
            log.error("entityToModel : 安全权限异常", e);
        }
        BeanUtils.copyProperties(entity, model);
        return (T)model;
    }

}
