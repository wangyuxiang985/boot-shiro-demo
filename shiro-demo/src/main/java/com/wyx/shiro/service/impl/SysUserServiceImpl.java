package com.wyx.shiro.service.impl;

import com.wyx.shiro.entity.SysUser;
import com.wyx.shiro.mapper.SysUserMapper;
import com.wyx.shiro.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author yu xiang
 * @since 2018-04-02 
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
