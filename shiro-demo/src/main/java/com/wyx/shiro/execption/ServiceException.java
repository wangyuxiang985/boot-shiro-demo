package com.wyx.shiro.execption;

import com.wyx.shiro.enums.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ServiceException
 * @Description 用于抛出业务逻辑异常
 * @Author yuxiang
 * @Date 2019/12/12
 * @Version 1.0
 **/
@Setter
@Getter
public class ServiceException extends RuntimeException {

    private Integer code;
    private String msg;

    public ServiceException() {
    }

    public ServiceException(String msg) {
        this.msg = msg;
    }

    public ServiceException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ServiceException(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
    }
}
