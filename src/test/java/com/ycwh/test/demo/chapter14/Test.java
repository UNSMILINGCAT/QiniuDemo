package com.ycwh.test.demo.chapter14;

public class Test
{
    @org.junit.Test
    public void test(){
        try
        {
            Class.forName("com.ycwh.test.demo.chapter14.Demo");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
