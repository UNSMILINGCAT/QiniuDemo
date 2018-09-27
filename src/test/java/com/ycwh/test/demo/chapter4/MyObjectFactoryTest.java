package com.ycwh.test.demo.chapter4;

import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyObjectFactoryTest
{
    @Test
    public void test() throws Exception
    {
        SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        String driver = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/ssm?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT%2B8";
//        Class.forName(driver);
//        Connection connection = DriverManager.getConnection(url,"不笑猫","yc123456");
//        System.out.println(connection.getMetaData().getDatabaseProductName());
    }
}
