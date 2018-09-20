package com.ycwh.demo.chapter2;


public class HelloWorldImp implements HelloWorld
{
    @Override
    public void sayHelloWorld()
    {
        System.out.println("HelloWorld");
    }

    @Override
    public void print()
    {
        System.out.println("print");
    }
}
