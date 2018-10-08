package com.ycwh.demo.chapter13.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.ycwh.demo.chapter13")
//使用事务驱动管理器
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class JavaConfig implements TransactionManagementConfigurer
{
    //数据源
    private DataSource dataSource = null;
    @Autowired
    private Environment environment;

    /**
     * 实现接口方法，使得返回数据库事务管理器
     *
     * @return
     */
    @Override
    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager()
    {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        //设置事务管理器管理的数据源
        transactionManager.setDataSource(initDataSource());
        return transactionManager;
    }

    /**
     * 配置数据源
     *
     * @return
     */
    @Bean
    public DataSource initDataSource()
    {
        if (dataSource != null)
        {
            return dataSource;
        }
        Properties properties = new Properties();
        try
        {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return dataSource;
    }

    /**
     * 配置JdbcTemplate
     *
     * @return
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate initJdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(initDataSource());
        return jdbcTemplate;
    }
}
