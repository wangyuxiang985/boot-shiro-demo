package com.wyx.shiro.mapper;

import com.wyx.shiro.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectSysMenuByRoleId(Long roleId);
}
