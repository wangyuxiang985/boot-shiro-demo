package com.wyx.shiro.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Data
@Accessors(chain = true)
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String perms;

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