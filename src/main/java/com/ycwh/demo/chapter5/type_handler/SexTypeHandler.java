package com.ycwh.demo.chapter5.type_handler;

import com.ycwh.demo.chapter5.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SexTypeHandler implements TypeHandler<SexEnum>
{
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws
            SQLException
    {
        preparedStatement.setInt(i, sexEnum.getIndex());
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, String s) throws SQLException
    {
        int index = resultSet.getInt(s);
        SexEnum sexEnum = SexEnum.values()[index];
        return sexEnum;
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, int i) throws SQLException
    {
        return null;
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int i) throws SQLException
    {
        return null;
    }
}
