package com.wyx.shiro.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "权限表")
public class SysMenuVo {


    /** 权限ID */
    @ApiModelProperty(value = "权限ID", required = true)
    private Long menuId;

    /** 权限名称 */
    @ApiModelProperty(value = "权限名称", required = true)
    private String name;

    /** 权限标识 */
    @ApiModelProperty(value = "权限标识", required = true)
    private String perms;

    /** 创建人id */
    @ApiModelProperty(value = "创建人id", required = true)
    private Long createBy;

    /** 创建时间戳 */
    @ApiModelProperty(value = "创建时间戳", required = true)
    private Long createTime;

    /** 更新人id */
    @ApiModelProperty(value = "更新人id", required = true)
    private Long updateBy;

    /** 更新人时间戳 */
    @ApiModelProperty(value = "更新人时间戳", required = true)
    private Long updateTime;

    /** 备注 */
    @ApiModelProperty(value = "备注", required = true)
    private String remark;

    /** 版本号，默认1 */
    @ApiModelProperty(value = "版本号，默认1", required = true)
    private Integer version;

}