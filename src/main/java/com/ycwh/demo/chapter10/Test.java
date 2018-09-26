package com.ycwh.demo.chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan(basePackageClasses = {Role.class})
public class Test
{
    public void test()
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(Test.class);
        Role role = (Role) context.getBean("role");
        System.out.println(role.getRoleName());
    }
}
