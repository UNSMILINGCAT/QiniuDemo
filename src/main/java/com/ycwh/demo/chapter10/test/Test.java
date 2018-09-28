package com.ycwh.demo.chapter10.test;

import com.ycwh.demo.chapter10.Role;
import com.ycwh.demo.chapter10.profile.ProfileDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ComponentScan(basePackageClasses = {Role.class})
public class Test
{
//    @Autowired
    private DataSource dataSource;

    public void test()
    {
//        ApplicationContext context=new AnnotationConfigApplicationContext(Test.class);
//        Role role = (Role) context.getBean("role");
//        System.out.println(role.getRoleName());
        Properties properties = new Properties();
        InputStream inputStream;
        try
        {
            inputStream = this.getClass().getResourceAsStream("/jdbc.properties");
            System.out.println(inputStream.available());
            properties.load(inputStream);
            System.out.println(properties.getProperty("jdbc.userName"));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
