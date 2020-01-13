package com.wyx.shiro.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "系统用户表")
public class SysUserVo {


    /** 用户ID */
    @ApiModelProperty(value = "用户ID", required = true)
    private Long userId;

    /** 用户名 */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /** 密码 */
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    /** 盐值 */
    @ApiModelProperty(value = "盐值", required = true)
    private String salt;

    /** 状态:0正常  1禁用 */
    @ApiModelProperty(value = "状态:0正常  1禁用", required = true)
    private Integer state;

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