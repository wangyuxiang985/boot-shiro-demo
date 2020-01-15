package com.wyx.shiro;

import com.wyx.shiro.utils.SpringUtil;
import org.apache.shiro.session.Session;
import org.crazycake.shiro.RedisSessionDAO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;

@SpringBootTest
class ShiroDemoApplicationTests {

    @Test
    void contextLoads() {
        RedisSessionDAO bean = SpringUtil.getBean(RedisSessionDAO.class);
        String keyPrefix = bean.getKeyPrefix();
        Collection<Session> activeSessions = bean.getActiveSessions();
    }



}
