package com.wyx.shiro.service;

import com.wyx.shiro.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
public interface ISysUserService extends IService<SysUser> {

    /**
     * @Author yuxiang
     * @Description //根据用户名查询用户实体
     * @Date 2020/1/15
     * @Param [username]
     * @return com.wyx.shiro.entity.SysUser
    **/
    SysUser selectUserByName(String username);
}
