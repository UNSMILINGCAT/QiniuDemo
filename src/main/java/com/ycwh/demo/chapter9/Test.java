package com.ycwh.demo.chapter9;

import com.ycwh.demo.chapter9.pojo.JuiceMaker2;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    public void test()
    {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter9/spring-cfx.xml");
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
        ctx.close();
    }
}
