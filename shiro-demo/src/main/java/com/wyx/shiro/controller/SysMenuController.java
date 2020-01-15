package com.wyx.shiro.controller;


import com.wyx.shiro.common.ServerResponse;
import com.wyx.shiro.entity.SysMenu;
import com.wyx.shiro.entity.SysRole;
import com.wyx.shiro.entity.SysRoleMenu;
import com.wyx.shiro.entity.SysUser;
import com.wyx.shiro.model.SysMenuVo;
import com.wyx.shiro.model.SysRoleVo;
import com.wyx.shiro.model.SysUserVo;
import com.wyx.shiro.service.ISysMenuService;
import com.wyx.shiro.service.ISysRoleMenuService;
import com.wyx.shiro.service.ISysRoleService;
import com.wyx.shiro.service.ISysUserService;
import com.wyx.shiro.utils.ShiroUtil;
import com.wyx.shiro.utils.TypeTransUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *权限测试
 * @author yu xiang
 * @since 2018-04-02 
 */
@RestController
@RequestMapping("/menu")
@Api(value = "SysMenuController", tags = {"权限测试"})
public class SysMenuController {

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ISysRoleService iSysRoleService;
    @Autowired
    private ISysMenuService iSysMenuService;
    @Autowired
    private ISysRoleMenuService iSysRoleMenuService;

    /**
     * 获取用户信息集合
     */
    @GetMapping("/getUserInfoList")
    @RequiresPermissions("sys:user:info")
    @ApiOperation("获取用户信息集合")
    public ServerResponse getUserInfoList(){
        List<SysUser> sysUserList = iSysUserService.list();
        List<SysUserVo> sysUserVos = TypeTransUtil.entityListToModelList(sysUserList, SysUserVo.class);
        return ServerResponse.success(sysUserVos);
    }

    /**
     * 获取角色信息集合
     */
    @GetMapping("/getRoleInfoList")
    @RequiresPermissions("sys:role:info")
    @ApiOperation("获取角色信息集合")
    public ServerResponse getRoleInfoList(){
        List<SysRole> sysRoleList = iSysRoleService.list();
        List<SysRoleVo> sysRoleVos = TypeTransUtil.entityListToModelList(sysRoleList, SysRoleVo.class);
        return ServerResponse.success(sysRoleVos);
    }

    /**
     * 获取权限信息集合
     */
    @GetMapping("/getMenuInfoList")
    @RequiresPermissions("sys:menu:info")
    @ApiOperation("获取权限信息集合")
    public ServerResponse getMenuInfoList(){
        List<SysMenu> sysMenuList = iSysMenuService.list();
        List<SysMenuVo> sysMenuVos = TypeTransUtil.entityListToModelList(sysMenuList, SysMenuVo.class);
        return ServerResponse.success(sysMenuVos);
    }

    /**
     * 获取所有数据
     */
    @GetMapping("/getInfoAll")
    @RequiresPermissions("sys:info:all")
    @ApiOperation("获取所有数据")
    public ServerResponse getInfoAll(){
        Map<String,Object> map = new HashMap<>();
        List<SysUser> sysUserList = iSysUserService.list();
        List<SysUserVo> sysUserVos = TypeTransUtil.entityListToModelList(sysUserList, SysUserVo.class);
        map.put("sysUserVoList",sysUserVos);
        List<SysRole> sysRoleList = iSysRoleService.list();
        List<SysRoleVo> sysRoleVos = TypeTransUtil.entityListToModelList(sysRoleList, SysRoleVo.class);
        map.put("sysRoleVoList",sysRoleVos);
        List<SysMenu> sysMenuList = iSysMenuService.list();
        List<SysMenuVo> sysMenuVos = TypeTransUtil.entityListToModelList(sysMenuList, SysMenuVo.class);
        map.put("sysMenuVoList",sysMenuVos);
        return ServerResponse.success(map);
    }

    /**
     * 添加管理员角色权限(测试动态权限更新)
     */
    @PostMapping("/addMenu")
    @ApiOperation("添加管理员角色权限(测试动态权限更新)")
    public ServerResponse addMenu(){
        //添加管理员角色权限
        SysRoleMenu sysRoleMenuEntity = new SysRoleMenu();
        sysRoleMenuEntity.setMenuId(4L);
        sysRoleMenuEntity.setRoleId(1L);
        iSysRoleMenuService.save(sysRoleMenuEntity);
        //清除缓存
        String username = "admin";
        ShiroUtil.deleteCache(username,false);
        return ServerResponse.success("权限添加成功");
    }

}
