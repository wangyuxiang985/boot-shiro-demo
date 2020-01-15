package com.wyx.shiro.service;

import com.wyx.shiro.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * @Author yuxiang
     * @Description //查询用户所拥有的角色
     * @Date 2020/1/13
     * @Param [userId]
     * @return java.util.List<com.wyx.shiro.entity.SysRole>
    **/
    List<SysRole> selectSysRoleByUserId(Long userId);
}
