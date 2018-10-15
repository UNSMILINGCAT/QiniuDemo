package com.ycwh.demo.chapter11.game.main;

import com.ycwh.demo.chapter11.game.ProxyBeanFactory;
import com.ycwh.demo.chapter11.game.interceptor.Interceptor;
import com.ycwh.demo.chapter11.game.interceptor.RoleInterceptor;
import com.ycwh.demo.chapter11.game.service.RoleService;
import com.ycwh.demo.chapter11.game.service.RoleServiceImpl;
import com.ycwh.pojo.Role;

public class GameMain
{
    public static void main(String[] args)
    {
        RoleService roleService = new RoleServiceImpl();
        Interceptor interceptor = new RoleInterceptor();
        RoleService proxy = ProxyBeanFactory.getBean(roleService, interceptor);
        Role role = new Role();
        proxy.printRole(role);
        System.out.println("############### 测 试 afterthrowing 方 法");
        role = null;
        proxy.printRole(role);
    }
}
