package com.ycwh.demo.chapter2;

import java.lang.reflect.InvocationTargetException;

public class ReflectService
{
    public static ReflectServiceImpl newInstance(String className)
    {
        ReflectServiceImpl reflectService = null;
        try
        {
            reflectService = (ReflectServiceImpl) Class.forName(className).newInstance();
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return reflectService;
    }

    public static ReflectServiceImpl newInstance(String className, String name)
    {
        ReflectServiceImpl reflectService = null;
        try
        {
            reflectService = (ReflectServiceImpl) Class.forName(className).getConstructor(String.class).newInstance
                    (name);
        } catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return reflectService;
    }
}
