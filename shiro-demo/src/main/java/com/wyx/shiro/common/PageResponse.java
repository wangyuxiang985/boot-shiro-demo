package com.wyx.shiro.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName PageResponse
 * @Description 多条件分页查询返回类
 * @Author yuxiang
 * @Date 2019/12/13
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> implements Serializable {

    private static final long serialVersionUID = 7498483649536881777L;

    @ApiModelProperty(value = "总条数")
    private Long total;

    @ApiModelProperty(value = "每页条数")
    private Long size;

    @ApiModelProperty(value = "总页数")
    private Long pages;

    @ApiModelProperty(value = "当前页")
    private Long current;

    @ApiModelProperty(value = "查询实体集合")
    private List<T> models;

    public PageResponse(Long total,Long size,Long pages,Long current){
        this.total = total;
        this.size = size;
        this.pages = pages;
        this.current = current;
    }

}
