package com.ycwh.demo.chapter10.profile;

import com.ycwh.demo.chapter10.annotation.condition.DataSourceCondition;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;

@Component
public class ProfileDataSource
{
    @Value("${jdbc.driver}")
    String driver = null;
    @Value("${jdbc.url}")
    String url = null;

    @Bean(name = "dataSource")
    @Conditional({DataSourceCondition.class})
    public DataSource getDataSource(@Value("${jdbc.driver}") String driver,
                                    @Value("${jdbc.url}") String url,
                                    @Value("${jdbc.username}") String username,
                                    @Value("${jdbc.password}") String password)
    {
        System.out.println(driver);
        System.out.println("getDataSource");
        Properties properties = new Properties();
        properties.setProperty("driver", driver);
        properties.setProperty("url", url);
        properties.setProperty("username", username);
        properties.setProperty("password", password);
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

    @Bean(name = {"devDataSource"})
    @Profile(value = "dev")
    public DataSource getDevDataSource()
    {
        System.out.println("getDevDataSource");
        Properties props = new Properties();
        DataSource dataSource = null;
        try
        {
            props.setProperty("driver", driver);
            props.setProperty("url", url);
            props.setProperty("username", "root");
            props.setProperty("password", "123456");
            System.out.println(props.getProperty("driver"));
            dataSource = BasicDataSourceFactory.createDataSource(props);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return dataSource;
    }
//
//    @Bean(name = "testDataSource")
//    @Profile(value = "test")
//    public DataSource getTestDataSource()
//    {
//        System.out.println("getTestDataSource");
//        Properties properties = new Properties();
//        properties.setProperty("driver", "com.mysql.cj.jdbc.Driver");
//        properties.setProperty("url", "jdbc:mysql://localhost:3306/ssm?useSSL=false&allowPublicKeyRetrieval=true" +
//                "&serverTimezone=GMT%2B8");
//        properties.setProperty("username", "root");
//        properties.setProperty("password", "123456");
//        DataSource dataSource = null;
//        try
//        {
//            dataSource = BasicDataSourceFactory.createDataSource(properties);
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
}
