package com.ycwh.test.demo.chapter10;

import com.ycwh.demo.chapter10.annotation.comfig.ApplicationConfig;
import com.ycwh.demo.chapter10.annotation.service.RoleDataSourceServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test
{

    @org.junit.Test
    public void test()
    {
        new ProfileTest().test();
    }

    @org.junit.Test
    public void testApplictionConfig()
    {
//        new ApplicationConfig().test();
        ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
        String url=context.getEnvironment().getProperty("jdbc.userName");
        System.out.println(url);
    }
}
