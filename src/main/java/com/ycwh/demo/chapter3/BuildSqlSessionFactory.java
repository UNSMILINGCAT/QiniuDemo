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


    private static void buildSqlSessionFactory()
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

    /**
     * 强制重构SqlSessionFactory
     * 一般用于修改了配置文件
     */
    private static void reBuildSqlSessionFactory()
    {
        buildSqlSessionFactory();
    }

    public static SqlSessionFactory getSqlSessionFactory()
    {
        if (sqlSessionFactory == null)
        {
            buildSqlSessionFactory();
        }
        return sqlSessionFactory;
    }

    /**
     * 设置读取的配置文件，如果不设置，则使用默认配置
     *
     * @param cfx
     */
    public static void setResource(String cfx)
    {
        resource = cfx;
        if (sqlSessionFactory != null)
        {
            reBuildSqlSessionFactory();
        }
    }
}
