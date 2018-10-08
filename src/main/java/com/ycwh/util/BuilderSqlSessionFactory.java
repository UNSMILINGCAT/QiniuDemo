package com.ycwh.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BuilderSqlSessionFactory
{
    /**
     * 配置文件路径
     */
    private static final String CONFIG_PATH = "mybatis-config.xml";
    private static final Map<String, SqlSessionFactory> sqlSessionFactoryMap = new HashMap<>();
    private Resource configLocation;

    public Resource getConfigLocation()
    {
        return configLocation;
    }

    public void setConfigLocation(Resource configLocation)
    {
        this.configLocation = configLocation;
    }

    /**
     * 获取默认id为development的环境配置
     *
     * @return
     */
    public static SqlSessionFactory buildSqlSessionFactory()
    {
        return buildSqlSessionFactory("development");
    }

    /**
     * 根据传入的environment的id获取数据库环境配置
     *
     * @param environmentId
     * @return
     */
    public static SqlSessionFactory buildSqlSessionFactory(String environmentId)
    {
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryMap.get(environmentId);
        if (!Objects.isNull(sqlSessionFactory))
            return sqlSessionFactory;
        else
        {
            InputStream inputStream = null;
            try
            {
                inputStream = org.apache.ibatis.io.Resources.getResourceAsStream(CONFIG_PATH);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, environmentId);
            } catch (IOException io)
            {
                io.printStackTrace();
            } finally
            {
                try
                {
                    if (inputStream != null)
                        inputStream.close();
                } catch (IOException io)
                {
                    io.printStackTrace();
                }
            }
            sqlSessionFactoryMap.put(environmentId, sqlSessionFactory);
            return sqlSessionFactory;
        }
    }
}
