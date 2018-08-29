package com.ycwh.demo;

import java.lang.reflect.Method;

public class Demo
{
    public void main()
    {
        try
        {
            DemoReflect object = (DemoReflect) Class.forName("com.ycwh.demo.DemoReflect").newInstance();
            Method method = object.getClass().getMethod("print", null);
            method.invoke(object, null);
        } catch (Exception e)
        {

        }
    }
}
