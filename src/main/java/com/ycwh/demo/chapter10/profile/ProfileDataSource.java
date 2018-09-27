package com.ycwh.demo.chapter10.profile;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

@Component
public class ProfileDataSource
{
    @Bean(name = {"devDataSource"})
    @Profile(value = "dev")
    public DataSource getDevDataSource()
    {
        Properties props = new Properties();
        DataSource dataSource = null;
        try
        {
            props.load(Object.class.getResourceAsStream("jdbc.properties"));


            props.setProperty("driver", props.getProperty("jdbc.driver"));
            props.setProperty("url", "jdbc:mysql://localhost:3306/ssm?useSSL=false&allowPublicKeyRetrieval=true" +
                    "&serverTimezone=GMT%2B8");
            props.setProperty("username", "root");
            props.setProperty("password", "123456");

            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Bean(name = "testDataSource")
    @Profile(value = "test")
    public DataSource getTestDataSource()
    {
        System.out.println();
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/ssm?useSSL=false&allowPublicKeyRetrieval=true" +
                "&serverTimezone=GMT%2B8");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        DataSource dataSource = null;
        try
        {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return dataSource;
    }
}
