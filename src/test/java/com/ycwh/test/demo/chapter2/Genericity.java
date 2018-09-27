package com.ycwh.test.demo.chapter2;

import org.junit.Test;

public class Genericity<T>
{
    public void print(T t)
    {
        System.out.println(t);
    }

    public <T> void println(T t)
    {
        System.out.println(t);
    }

    @Test
    public void test()
    {
        Genericity<String> genericity = new Genericity<>();
        genericity.print("ni");
        genericity.println(2);
    }
}
