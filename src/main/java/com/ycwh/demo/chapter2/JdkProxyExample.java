package com.ycwh.demo.chapter2;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample<T> implements InvocationHandler
{
    //真实对象
    private T target;

    /**
     * 建立代理对象和真实对象的代理关系，并换回代理对象
     *
     * @param target 真实对象
     * @return
     */
    @SuppressWarnings("unchecked")
    public T bind(T target)
    {
        this.target = target;
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理方法逻辑
     *
     * @param proxy  代理对象
     * @param method 当前调度方法
     * @param args   当前方法参数
     * @return 代理结果返回
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        Object obj = method.invoke(target, args); //相当于调用sayHelloWorld方法
        return obj;
    }
}
