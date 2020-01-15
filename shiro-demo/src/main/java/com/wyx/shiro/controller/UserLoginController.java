package com.wyx.shiro.controller;

import com.wyx.shiro.common.ServerResponse;
import com.wyx.shiro.entity.SysUser;
import com.wyx.shiro.entity.SysUserRole;
import com.wyx.shiro.service.ISysUserRoleService;
import com.wyx.shiro.service.ISysUserService;
import com.wyx.shiro.utils.SHA256Util;
import com.wyx.shiro.utils.ShiroUtil;
import io.swagger.annotations.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserLoginController
 * @Description 用户登录
 * @Author yuxiang
 * @Date 2020/1/15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/userLogin")
@Api(value = "UserLoginController", tags = {"用户登录"})
public class UserLoginController {

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private ISysUserRoleService iSysUserRoleService;

    /**
     * 登录
     */
    @PostMapping("/login")
    @ApiOperation("登录")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "sysUser", value = "登录用户", dataType = "SysUser", paramType = "body", required = true)
    )
    public ServerResponse login(@RequestBody SysUser sysUser){
        //进行身份验证
        try{
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
            //验证成功进行登录操作
            subject.login(token);
        }catch (IncorrectCredentialsException e) {
            return ServerResponse.error("用户不存在或者密码错误");
        } catch (LockedAccountException e) {
            return ServerResponse.error("登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return ServerResponse.error("该用户不存在");
        } catch (Exception e) {
            return ServerResponse.error("未知异常");
        }
        Map<String, String> map = new HashMap<>();
        map.put("token", ShiroUtil.getSession().getId().toString());
        return ServerResponse.success("登录成功",map);
    }

    /**
     * 添加一个用户演示接口
     * 这里仅作为演示不加任何权限和重复查询校验
     */
    @PostMapping("/testAddUser")
    @ApiOperation("添加一个用户接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "String", paramType = "query", required = true),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query", required = true)
    })
    public ServerResponse testAddUser(String username, String password){
        // 设置基础参数
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setState(0);
        // 随机生成盐值
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUser.setSalt(salt);
        // 进行加密
        sysUser.setPassword(SHA256Util.sha256(password, sysUser.getSalt()));
        // 保存用户
        iSysUserService.save(sysUser);
        // 保存角色
        SysUserRole sysUserRole = new SysUserRole();
        // 保存用户完之后会把ID返回给用户实体
        sysUserRole.setUserId(sysUser.getUserId());
        iSysUserRoleService.save(sysUserRole);
        // 返回结果
        Map<String,Object> map = new HashMap<>();
        return ServerResponse.success("添加成功");
    }

    /**
     * 未登录
     */
    @GetMapping("/unauth")
    @ApiOperation("未登录")
    public ServerResponse unauth(){
        return ServerResponse.error("未登录");
    }


}
