package com.ycwh.test.demo.chapter13;

import com.ycwh.demo.chapter13.controller.RoleController;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RoleControllerTest
{
    Logger logger = Logger.getLogger(this.getClass());

    @Test
    public void test()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter13/spring-13.xml");
        RoleController roleController = ctx.getBean(RoleController.class);
        roleController.errerUserService();
    }
}
