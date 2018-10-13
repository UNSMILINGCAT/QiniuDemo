package com.ycwh.demo.chapter11.game;

import com.ycwh.demo.chapter11.game.interceptor.Interceptor;

public class ProxyBeanFactory
{
    @SuppressWarnings("unchecked")
    public static <T> T getBean(T obj, Interceptor interceptor)
    {
        return (T) ProxyBeanUtil.getBean(obj, interceptor);
    }
}
