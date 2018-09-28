package com.ycwh.demo.chapter1;

import java.lang.reflect.Method;

public class Demo
{
    public void main()
    {
        try
        {
            DemoReflect object = (DemoReflect) Class.forName("com.ycwh.demo.chapter1.DemoReflect").newInstance();
            Method method = object.getClass().getMethod("print", null);
            method.invoke(object, null);
        } catch (Exception e)
        {

        }
    }
}
