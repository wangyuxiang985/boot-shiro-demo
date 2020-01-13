package com.wyx.shiro.controller;


import com.wyx.shiro.entity.SysUser;
import com.wyx.shiro.service.ISysMenuService;
import com.wyx.shiro.service.ISysUserService;
import com.wyx.shiro.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@RestController
@RequestMapping("/shiro/user")
@CrossOrigin(origins = "*",allowCredentials = "true")
@Api(value = "SysUserController",tags = {"用户操作API"})
public class SysUserController {

    @Autowired
    private ISysUserService iSysUserService;

    @GetMapping("/test/{userId}")
    @ApiOperation("测试是否通透")
    public SysUser testGetSysUser(@PathVariable Long userId) {
        return iSysUserService.getById(userId);
    }

}
