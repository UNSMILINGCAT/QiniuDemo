package com.ycwh.test.demo.chapter10;

import com.ycwh.demo.chapter10.Role;
import com.ycwh.demo.chapter10.el.ELBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;

@ComponentScan(basePackageClasses = {ELBean.class,Role.class})
public class ELBeanTest
{
    @Test
    public void test()
    {
        ApplicationContext context =new AnnotationConfigApplicationContext(ELBeanTest.class);
        ELBean elBean=(ELBean)context.getBean("elBean");
        System.out.println(elBean.getRole().getRoleName());
    }
}
