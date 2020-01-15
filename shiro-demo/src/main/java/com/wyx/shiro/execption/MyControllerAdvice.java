package com.wyx.shiro.execption;

import com.wyx.shiro.common.ServerResponse;
import com.wyx.shiro.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName MyControllerAdvice
 * @Description 全局异常处理
 * @Author yuxiang
 * @Date 2019/12/12
 * @Version 1.0
 **/
@ControllerAdvice
@Slf4j
public class MyControllerAdvice {

    /**
     * 处理Shiro权限拦截异常
     */
    @ResponseBody
    @ExceptionHandler(value = AuthorizationException.class)
    public ServerResponse authorizationExceptionHandler(AuthorizationException ae){
        log.error("程序运行时抛出自定义异常，ServiceException:{} ", ae.getMessage());
        return ServerResponse.custom(403,"权限不足!");
    }

    /**
    * 处理抛出的服务异常
    **/
    @ResponseBody
    @ExceptionHandler(ServiceException.class)
    public ServerResponse serviceExceptionHandler(ServiceException se) {
        log.error("程序运行时抛出自定义异常，ServiceException:{} ", se.getMsg());
        if(se.getCode() != null){
            if(ResponseCode.SUCCESS.getCode().equals(se.getCode())){
                return ServerResponse.success(se.getMsg());
            }
            return ServerResponse.custom(se.getCode(), se.getMsg());
        }else {
            return ServerResponse.error(se.getMsg());
        }
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ServerResponse exceptionHandler(Exception e) {
        log.error("程序运行时抛出未知异常，Exception: ", e);
        return ServerResponse.error(ResponseCode.SERVER_ERROR.getMsg() + "\t" + e.getMessage());
    }
}
