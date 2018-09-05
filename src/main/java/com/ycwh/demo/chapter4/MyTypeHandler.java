package com.ycwh.demo.chapter4;

import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MyTypeHandler implements TypeHandler<String>
{
    Logger logger = Logger.getLogger(MyTypeHandler.class);

    /**
     * 用于定义在MyBatis设置参数时该如何把java类型的参数转换为对应的数据库类型
     *
     * @param preparedStatement
     * @param i                 当前参数的位置
     * @param s                 当前参数的java对象
     * @param jdbcType          当前参数的数据库类型
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws
            SQLException
    {
        logger.info("设置string参数【" + s + "】");
        preparedStatement.setString(i, s);
    }

    /**
     * 用于在MyBatis获取数据结果集时如何把数据库类型转换为对应的java类型
     *
     * @param resultSet 当前的结果集
     * @param s         当前的字段名称
     * @return
     * @throws SQLException
     */
    @Override
    public String getResult(ResultSet resultSet, String s) throws SQLException
    {
        String result = resultSet.getString(s);
        logger.info("获取string参数【" + result + "】");
        return result;
    }

    /**
     * 用于MyBatis通过字段位置获取字段数据时把数据库类型转换为对应的java类型
     *
     * @param resultSet 当前的结果集
     * @param i         当前字段的位置
     * @return
     * @throws SQLException
     */
    @Override
    public String getResult(ResultSet resultSet, int i) throws SQLException
    {
        String result = resultSet.getString(i);
        logger.info("通过int获取参数【" + result + "】");
        return result;
    }

    /**
     * 用于Mybatis在调用存储过程后把数据库类型的数据转换为对应的java类型
     *
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public String getResult(CallableStatement callableStatement, int i) throws SQLException
    {
        return null;
    }
}
