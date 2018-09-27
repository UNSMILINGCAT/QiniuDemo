package com.ycwh.test.demo.chapter10;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;


public class ProfileTest
{
    @Autowired
    private DataSource dataSource;

    @Test
    public void test()
    {
        System.out.println(dataSource.getClass().getName());
    }
}
