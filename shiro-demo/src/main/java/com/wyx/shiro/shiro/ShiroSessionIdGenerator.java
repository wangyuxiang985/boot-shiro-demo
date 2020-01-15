package com.wyx.shiro.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;

/**
 * @ClassName ShiroSessionIdGenerator
 * @Description 自定义SessionId生成器
 * @Author yuxiang
 * @Date 2020/1/13
 * @Version 1.0
 **/
public class ShiroSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        Serializable sessionId = new JavaUuidSessionIdGenerator().generateId(session);
        return String.format("login_token_%s", sessionId);
    }
}
