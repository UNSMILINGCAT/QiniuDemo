package com.ycwh.test.demo.annotation;

import com.ycwh.demo.annotation.UserCase;

import java.lang.reflect.Method;

public class Test
{
    @UserCase(value = "王林")
    @org.junit.Test
    public void test()
    {
        try
        {
            Method method=Test.class.getMethod("test");
            System.out.println(method);
            System.out.println(method.getAnnotation(UserCase.class));
        } catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
    }
}
