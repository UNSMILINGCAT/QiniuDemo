package com.ycwh.demo.chapter4;

import com.sun.istack.internal.logging.Logger;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class MyObjectFactory extends DefaultObjectFactory
{
    Logger logger = Logger.getLogger(MyObjectFactory.class);

    @Override
    public void setProperties(Properties properties)
    {
        super.setProperties(properties);
        logger.info(properties.toString());
    }

    @Override
    public <T> T create(Class<T> type)
    {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs)
    {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public <T> boolean isCollection(Class<T> type)
    {
        return super.isCollection(type);
    }
}
