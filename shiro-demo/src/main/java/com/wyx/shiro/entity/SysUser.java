package com.wyx.shiro.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Data
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 状态:0正常  1禁用
     */
    private Integer state;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 创建时间戳
     */
    @TableField(value="create_time", fill = FieldFill.INSERT)
    private Long createTime;

    /**
     * 更新人id
     */
    private Long updateBy;

    /**
     * 更新人时间戳
     */
    @TableField(value="create_time", fill = FieldFill.UPDATE)
    private Long updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 版本号，默认1
     */
    @Version
    @TableField(value="version", fill = FieldFill.INSERT, update="%s+1")
    private Integer version;


}