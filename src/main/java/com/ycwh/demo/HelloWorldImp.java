package com.ycwh.demo;

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
        System.out.print("print");
    }
}
