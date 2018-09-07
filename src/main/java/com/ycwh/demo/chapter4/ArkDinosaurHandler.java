package com.ycwh.demo.chapter4;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArkDinosaurHandler implements TypeHandler<String[]>
{
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws
            SQLException
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (String feed : strings)
        {
            if (feed.equals(strings[strings.length - 1]))
            {
                stringBuffer.append(feed);
                break;
            }
            stringBuffer.append(feed + " ");
        }
        preparedStatement.setString(i, stringBuffer.toString());
    }

    @Override
    public String[] getResult(ResultSet resultSet, String s) throws SQLException
    {
        String feed = resultSet.getString(s);
        String[] feeds = feed.split(" ");
        return feeds;
    }

    @Override
    public String[] getResult(ResultSet resultSet, int i) throws SQLException
    {
        return new String[0];
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int i) throws SQLException
    {
        return new String[0];
    }
}
