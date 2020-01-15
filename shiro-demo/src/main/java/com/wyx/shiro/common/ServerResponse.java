package com.wyx.shiro.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wyx.shiro.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @ClassName ServerResponse
 * @Description 服务返回封装体
 * @Author yuxiang
 * @Date 2019/12/12
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ServerResponse<T> implements Serializable {

    private static final long serialVersionUID = 7498483649536881777L;

    private Integer status;

    private String msg;

    private T data;


    @JsonIgnore
    public boolean isSuccess() {
        return ResponseCode.SUCCESS.getCode().equals(this.status);
    }

    public static ServerResponse success() {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), null, null);
    }

    public static ServerResponse success(String msg) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, null);
    }

    public static <T> ServerResponse success(T data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    public static <T> ServerResponse success(String msg,T data) {
        return new ServerResponse(ResponseCode.SUCCESS.getCode(), msg, data);
    }

    public static ServerResponse error(String msg) {
        return new ServerResponse(ResponseCode.ERROR.getCode(), msg, null);
    }

    public static ServerResponse custom(Integer status,String msg){
        return new ServerResponse(status, msg,null);
    }

    public static <T> ServerResponse custom(Integer status,String msg,T data){
        return new ServerResponse(status, msg,data);
    }

}
