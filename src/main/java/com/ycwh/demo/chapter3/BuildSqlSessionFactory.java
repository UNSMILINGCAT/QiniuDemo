package com.ycwh.demo.chapter3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class BuildSqlSessionFactory
{
    private static SqlSessionFactory sqlSessionFactory = null;
    private static String resource = "mybatis-config.xml";

    public static void buildSqlSessionFactory()
    {
        InputStream inputStream;
        try
        {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory()
    {
        if (sqlSessionFactory == null)
        {
            buildSqlSessionFactory();
        }
        return sqlSessionFactory;
    }
}
