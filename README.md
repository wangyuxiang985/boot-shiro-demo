# boot-shiro-demo
SpringBoot整合Shiro实现动态权限加载更新+Session共享+单点登录
***
**主要插件版本**
1. SpringBoot版本:2.2.2
2. MyBatis-Plus版本: 3.3.0
3. JDK版本:1.8    
4. Shiro版本:1.4    
5. Shiro-redis插件版本:3.1.0

***
**数据库表**  

数据库表     | 中文释义 | 备注
-------- | -----|--------------
sys_user |	系统用户表 |	基础表
sys_menu |	权限表 |	基础表
sys_role |	角色表 | 基础表
sys_role_menu | 角色与权限关系表 | 中间关系表
sys_user_role | 用户与角色关系表 | 中间关系表
    
    
    
    
