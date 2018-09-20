package com.ycwh.demo.chapter2;

public class JdkProxyTest
{
    public void testJdkProxy()
    {
        JdkProxyExample<HelloWorld> jdk = new JdkProxyExample();
        HelloWorld proxy = jdk.bind(new HelloWorldImp());
        proxy.sayHelloWorld();
    }
}
