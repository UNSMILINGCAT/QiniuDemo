package com.ycwh.test.demo.chapter7;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class Test
{
    SqlSessionFactory sqlSessionFactory;
    Logger logger = Logger.getLogger(Test.class);

    @org.junit.Test
    public void test()
    {
        InputStream cfxStream = null;
        try
        {
            cfxStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(cfxStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            if (cfxStream != null)
            {
                try
                {
                    cfxStream.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        Configuration configuration = sqlSessionFactory.getConfiguration();
        Environment environment = configuration.getEnvironment();
        logger.info(environment.getId());
    }
}
