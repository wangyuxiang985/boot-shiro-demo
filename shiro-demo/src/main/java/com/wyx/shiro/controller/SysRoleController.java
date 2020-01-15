package com.wyx.shiro.controller;


import com.wyx.shiro.common.ServerResponse;
import com.wyx.shiro.service.ISysMenuService;
import com.wyx.shiro.service.ISysRoleMenuService;
import com.wyx.shiro.service.ISysRoleService;
import com.wyx.shiro.service.ISysUserService;
import com.wyx.shiro.utils.ShiroUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * 角色测试
 * </p>
 *注解名称	说明
 * RequiresAuthentication	使用该注解标注的类,方法等在访问时,当前Subject必须在当前session中已经过认证.
 * RequiresGuest	使用该注解标注的类,方法等在访问时,当前Subject可以是“gust”身份,不需要经过认证或者在原先的session中存在记录.
 * RequiresUser	验证用户是否被记忆,有两种含义:一种是成功登录的(subject.isAuthenticated()结果为true);另外一种是被记忆的(subject.isRemembered()结果为true).
 * RequiresPermissions	当前Subject需要拥有某些特定的权限时,才能执行被该注解标注的方法.如果没有权限,则方法不会执行还会抛出AuthorizationException异常.
 * RequiresRoles	当前Subject必须拥有所有指定的角色时,才能访问被该注解标注的方法.如果没有角色,则方法不会执行还会抛出AuthorizationException异常.
 * @author yu xiang
 * @since 2018-04-02 
 */
@RestController
@RequestMapping("/role")
@Api(value = "SysRoleController", tags = {"用户角色测试"})
public class SysRoleController {


    /**
     * 管理员角色测试接口
     */
    @GetMapping("/getAdminInfo")
    @RequiresRoles("ADMIN")
    @ApiOperation("管理员角色测试接口")
    public ServerResponse getAdminInfo(){
        return ServerResponse.success("这里是只有管理员角色能访问的接口,ADMIN");
    }

    /**
     * 用户角色测试接口
     */
    @GetMapping("/getUserInfo")
    @RequiresRoles("USER")
    @ApiOperation("用户角色测试接口")
    public ServerResponse getUserInfo(){
        return ServerResponse.success("这里是只有用户角色能访问的接口,USER");
    }

    /**
     * 角色测试接口
     */
    @GetMapping("/getRoleInfo")
    @RequiresRoles(value={"ADMIN","USER"},logical = Logical.OR)
    @RequiresUser
    @ApiOperation("角色测试接口")
    public ServerResponse getRoleInfo(){
        return ServerResponse.success("这里是只要有ADMIN或者USER角色能访问的接口");
    }

    /**
     * 登出(测试登出)
     */
    @GetMapping("/getLogout")
    @RequiresUser
    @ApiOperation("登出(测试登出)")
    public ServerResponse getLogout(){
        ShiroUtil.logout();
        return ServerResponse.success("登出");
    }

}
