package com.ycwh.demo.chapter2;

public class ReflectServiceImpl
{
    public ReflectServiceImpl()
    {
        System.out.println("无参构造");
    }

    public ReflectServiceImpl(String name)
    {
        System.out.println("有参构造");
    }

    public void sayHello()
    {
        System.out.println("HelloWorld");
    }

    public void sayHello(String name)
    {
        System.out.println(name);
    }
}
