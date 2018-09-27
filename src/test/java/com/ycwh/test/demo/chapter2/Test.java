package com.ycwh.test.demo.chapter2;

import com.ycwh.demo.chapter2.ReflectService;
import com.ycwh.demo.chapter2.ReflectServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test
{
    @org.junit.Test
    public void test()
    {
        ReflectServiceImpl reflectService = ReflectService.newInstance("ReflectServiceImpl", "");
        try
        {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            method.invoke(reflectService, "你好");
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
    }
}
