package com.ycwh.demo.chapter10;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public void test()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter10/spring-cfx.xml");
        Role role = (Role) ctx.getBean("role");
        System.out.println(role.getRoleName());
    }
}
