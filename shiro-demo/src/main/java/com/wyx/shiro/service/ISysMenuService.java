package com.wyx.shiro.service;

import com.wyx.shiro.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * @Author yuxiang
     * @Description //角色拥有的权限
     * @Date 2020/1/13
     * @Param [roleId]
     * @return java.util.List<com.wyx.shiro.entity.SysMenu>
    **/
    List<SysMenu> selectSysMenuByRoleId(Long roleId);
}
