package com.ycwh.demo.chapter4;

import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexEnumTypeHandler implements TypeHandler<SexEnum>
{
    Logger logger = Logger.getLogger(SexEnumTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws
            SQLException
    {
        preparedStatement.setString(i, sexEnum.getSex());
        logger.info(sexEnum.getSex());
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, String s) throws SQLException
    {
        String sex = resultSet.getString(s);
        return SexEnum.getSexByName(sex);
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, int i) throws SQLException
    {
        String sex = resultSet.getString(i);
        return SexEnum.getSexByName(sex);
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int i) throws SQLException
    {
        String sex = callableStatement.getString(i);
        return SexEnum.getSexByName(sex);
    }
}
