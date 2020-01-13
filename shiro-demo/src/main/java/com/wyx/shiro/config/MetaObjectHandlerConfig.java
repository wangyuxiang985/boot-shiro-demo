package com.wyx.shiro.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;

/**
 * @ClassName MetaObjectHandlerConfig
 * @Description TODO
 * @Author yuxiang
 * @Date 2019/12/12
 * @Version 1.0
 **/
@Component
@Slf4j
public class MetaObjectHandlerConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("********** MetaObjectHandlerConfig insertFill 插入方法实体填充");


        Long userId = 1L;
        Long time = new Date().getTime();
        this.setFieldValByName("createBy", 1L, metaObject);
        this.setFieldValByName("createTime", time, metaObject);
        this.setFieldValByName("createBy", userId, metaObject);
        Object version = this.getFieldValByName("version", metaObject);
        if(Objects.isNull(version)){
            this.setFieldValByName("version", 0, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("********** MetaObjectHandlerConfig updateFill 更新方法实体填充");

        long time = new Date().getTime();
        this.setFieldValByName("updateTime", time, metaObject);
    }

}
