package com.ycwh.demo.chapter3;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class MySqlSessionFactory
{
    private static SqlSessionFactory sqlSessionFactory = null;


    /**
     * 创建数据库连接池信息s
     */
    public static void createSqlSessionFactory()
    {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUsername("不笑猫");
        dataSource.setPassword("yc123456");
        dataSource.setUrl("jdbc:mysql://localhost:3306/cao");
        dataSource.setDefaultAutoCommit(false);
        //采用MyBatis的JDBC事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        //创建Configuration对象
        Configuration configuration = new Configuration(environment);
        //注册一个MyBatis上下文别名
        configuration.getTypeAliasRegistry().registerAlias("role", Role.class);
        //加入一个映射器
        configuration.addMapper(RoleMapper.class);
        //使用SqlSessionFactoryBuilder构建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    /**
     * 返回数据库的SessionFactory
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactory()
    {
        if (sqlSessionFactory == null)
        {
            createSqlSessionFactory();
        }
        return sqlSessionFactory;
    }
}
