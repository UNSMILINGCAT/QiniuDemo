package com.ycwh.demo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyExample implements net.sf.cglib.proxy.MethodInterceptor
{
    /**
     * 生成CGLIB代理对象
     *
     * @param cls ----class类
     * @return Class类的CGLIB代理对象
     */
    public Object getProxy(Class cls)
    {
        //CGLIB enhancer增强类对象
        Enhancer enhancer = new Enhancer();
        //设置增强类型
        enhancer.setSuperclass(cls);
        //定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor方法
        enhancer.setCallback(this);
        //生成并返回代理对象
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     *
     * @param o
     * @param method
     * @param objects 方法参数
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
    {
        Object result=methodProxy.invokeSuper(o,objects);
        System.out.println(result);
        return result;
    }
}
