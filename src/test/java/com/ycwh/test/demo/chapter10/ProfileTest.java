package com.ycwh.test.demo.chapter10;

import com.ycwh.demo.chapter10.annotation.comfig.ApplicationConfig;
import com.ycwh.demo.chapter10.profile.ProfileConfig;
import com.ycwh.demo.chapter10.profile.ProfileDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
//@ActiveProfiles("dev")
//@Import({ApplicationConfig.class})
public class ProfileTest
{
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    @Test
    public void test()
    {
        System.out.println(dataSource.getClass().getName());
//        com.ycwh.demo.chapter10.test.ProfileTest profileTest = new com.ycwh.demo.chapter10.test.ProfileTest();
//        profileTest.test();
    }
}
