package com.ycwh.demo.chapter10.test;

import com.ycwh.demo.chapter10.annotation.comfig.ApplicationConfig;
import com.ycwh.demo.chapter10.profile.ProfileDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@ComponentScan(basePackageClasses = {ProfileDataSource.class})
@PropertySource(value = {"classpath:jdbc.properties"})
public class ProfileTest
{
    //自动装载
    @Autowired
    //当有多个配置时，限定自动配置者
    @Qualifier(value = "dataSource")
    private DataSource dataSource = null;

    public static void test()
    {
        System.out.println(new ProfileTest().dataSource.getClass().getName());
//        ApplicationContext applicationConfig = new AnnotationConfigApplicationContext(ProfileTest.class);
//        DataSource dataSource = (DataSource) applicationConfig.getBean("dataSource");


    }
}
