package com.wyx.shiro.enums;

/**
 * @ClassName ResponseCode
 * @Description 服务返回状态码
 * @Author yuxiang
 * @Date 2019/12/12
 * @Version 1.0
 **/
public enum ResponseCode {

    // 系统模块
    SUCCESS(200, "操作正常结束"),
    ERROR(201, "操作失败，异常catch住"),
    SERVER_ERROR(500, "服务器异常"),

    //业务操作模块1000-2000
    ADD_OR_UPDATE_SUCCESS(1000,"新增或更新成功"),
    ADD_OR_UPDATE_FAIL(1001,"新增或更新失败"),
    DELETE_SUCCESS(1002,"删除成功"),
    DELETE_FAIL(1003,"删除失败"),
    QUERY_SUCCESS(1004,"查询成功"),
    QUERY_FAIL(1005,"查询失败"),
    QUERY_IS_NULL(1006,"根据条件查询结果为空"),
    ILLEGAL_ARGUMENT(1007,"请求参数不合法，请检查"),
    FILE_CONVERSION_EXCEPTION(1008, "文件格式转换出现异常"),


    //调用外部服务状态码2001-3000
    ;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;

    private String msg;

    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
