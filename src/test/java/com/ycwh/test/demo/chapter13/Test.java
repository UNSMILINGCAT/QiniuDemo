package com.ycwh.test.demo.chapter13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class Test
{
    @org.junit.Test
    public void test()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("chapter13/spring-cfx.xml");
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        TransactionDefinition def = new DefaultTransactionDefinition();
        PlatformTransactionManager transactionManager = ctx.getBean(PlatformTransactionManager.class);
        TransactionStatus status = transactionManager.getTransaction(def);
        try
        {
            jdbcTemplate.update("insert into t_role(role_name,note) values ('柳眉','昆虚圣女分身')");
//            transactionManager.commit(status);
        } catch (Exception e)
        {
            transactionManager.rollback(status);
        }
    }
}
