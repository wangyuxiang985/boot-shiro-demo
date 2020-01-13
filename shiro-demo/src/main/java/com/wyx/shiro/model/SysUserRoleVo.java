package com.wyx.shiro.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户与角色关系表
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(description = "用户与角色关系表")
public class SysUserRoleVo {


    /** ID */
    @ApiModelProperty(value = "ID", required = true)
    private Long id;

    /** 用户ID */
    @ApiModelProperty(value = "用户ID", required = true)
    private Long userId;

    /** 角色ID */
    @ApiModelProperty(value = "角色ID", required = true)
    private Long roleId;

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