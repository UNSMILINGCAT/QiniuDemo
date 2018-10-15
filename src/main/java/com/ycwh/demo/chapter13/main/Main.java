package com.ycwh.demo.chapter13.main;

import com.ycwh.demo.chapter13.service.RoleListService;
import com.ycwh.pojo.Role;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter13/spring-13.xml");
        RoleListService roleListService = ctx.getBean(RoleListService.class);
        List<Role> roleList = new ArrayList<>();
        for (int i = 1; i <= 2; i++)
        {
            Role role = new Role();
            role.setRoleName("role_name" + i);
            role.setNote("note_" + i);
            roleList.add(role);
        }
        int count = roleListService.insertRoleList(roleList);
        System.out.println(count);
    }
}
