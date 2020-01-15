package com.wyx.shiro.shiro;

import com.wyx.shiro.entity.SysMenu;
import com.wyx.shiro.entity.SysRole;
import com.wyx.shiro.entity.SysUser;
import com.wyx.shiro.service.ISysMenuService;
import com.wyx.shiro.service.ISysRoleService;
import com.wyx.shiro.service.ISysUserService;
import com.wyx.shiro.utils.ShiroUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description Shiro权限匹配和账号密码匹配
 * @Author yuxiang
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysRoleService iSysRoleService;

    @Autowired
    private ISysMenuService iSysMenuService;

    @Autowired
    private ISysUserService iSysUserService;

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @Author Sans
     * @CreateTime 2019/6/12 11:44
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        //获取用户ID
        Long userId =sysUser.getUserId();
        //这里可以进行授权和处理
        Set<String> rolesSet = new HashSet<>();//角色列表
        Set<String> permsSet = new HashSet<>();//权限列表
        //查询角色和权限
        List<SysRole> SysRoleList = iSysRoleService.selectSysRoleByUserId(userId);
        for (SysRole SysRole:SysRoleList) {
            rolesSet.add(SysRole.getRoleName());
            List<SysMenu> SysMenuList = iSysMenuService.selectSysMenuByRoleId(SysRole.getRoleId());
            for (SysMenu SysMenu :SysMenuList) {
                permsSet.add(SysMenu.getPerms());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        authorizationInfo.setStringPermissions(permsSet);
        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     * 身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入账号
        String username = (String) authenticationToken.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到进行验证
        //实际项目中,这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制,2分钟内不会重复执行该方法
        SysUser user = iSysUserService.selectUserByName(username);
        //判断账号是否存在
        if (user == null) {
            throw new AuthenticationException();
        }
        //判断账号是否被冻结
        if (user.getState() == null ||1 == user.getState()){
            throw new LockedAccountException();
        }
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,                                  //用户名
                user.getPassword(),                    //密码
                ByteSource.Util.bytes(user.getSalt()), //设置盐值
                getName()
        );
        //验证成功开始踢人(清除缓存和Session)
        ShiroUtil.deleteCache(username,true);
        return authenticationInfo;
    }
}
