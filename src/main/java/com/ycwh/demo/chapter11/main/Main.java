package com.ycwh.demo.chapter11.main;

import com.ycwh.demo.chapter11.aop.config.AopConfig;
import com.ycwh.demo.chapter11.aop.service.RoleService;
import com.ycwh.demo.chapter11.aop.service.RoleServiceImpl;
import com.ycwh.demo.chapter11.game.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AopConfig.class);
        RoleService roleService = ctx.getBean(RoleService.class);
        Role role = new Role();
        role.setId(1);
        role.setRoleName("role_name_1");
        role.setNote("note_1");
        roleService.printRole(role);
        System.out.println("#########################");
        //测试异常通知
        role = null;
//        roleService.printRole(role);
    }
}
