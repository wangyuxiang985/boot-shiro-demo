package com.wyx.shiro.utils;

import com.wyx.shiro.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.LogoutAware;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.crazycake.shiro.RedisSessionDAO;

import java.util.Collection;
import java.util.Objects;

/**
 * @ClassName ShiroUtil
 * @Description Shiro工具类
 * @Author yuxiang
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class ShiroUtil {

    /** 私有构造器 **/
    private ShiroUtil(){}

    private static RedisSessionDAO redisSessionDAO = SpringUtil.getBean(RedisSessionDAO.class);

    /**
     * 获取当前用户Session
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 用户登出
     */
    public static void logout() {
        SecurityUtils.getSubject().logout();
    }

    /**
     * 获取当前用户信息
     */
    public static SysUser getUserInfo() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 删除用户缓存信息
     * username  用户名称
     * isRemoveSession 是否删除Session
     */
    public static void deleteCache(String username, boolean isRemoveSession){
        //从缓存中获取Session
        Session session = null;
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        SysUser sysUser;
        Object attribute = null;
        for(Session sessionInfo : sessions){
            //遍历Session,找到该用户名称对应的Session
            attribute = sessionInfo.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if (attribute == null) {
                continue;
            }
            sysUser = (SysUser) ((SimplePrincipalCollection) attribute).getPrimaryPrincipal();
            if (sysUser == null) {
                continue;
            }
            if (Objects.equals(sysUser.getUsername(), username)) {
                session=sessionInfo;
                break;
            }
        }
        if (session == null||attribute == null) {
            return;
        }
        //删除session
        if (isRemoveSession) {
            redisSessionDAO.delete(session);
        }
        //删除Cache，在访问受限接口时会重新授权
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        Authenticator authc = securityManager.getAuthenticator();
        ((LogoutAware) authc).onLogout((SimplePrincipalCollection) attribute);
    }

}
