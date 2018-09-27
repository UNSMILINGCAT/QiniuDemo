package com.ycwh.test.demo.chapter10;

import com.ycwh.demo.chapter10.annotation.comfig.ApplicationConfig;

public class Test
{

    @org.junit.Test
    public void test()
    {
//        com.ycwh.demo.chapter10.test.Test test = new com.ycwh.demo.chapter10.test.Test();
//        test.test();
        new ProfileTest().test();
    }

    @org.junit.Test
    public void testApplictionConfig()
    {
        new ApplicationConfig().test();
    }
}
