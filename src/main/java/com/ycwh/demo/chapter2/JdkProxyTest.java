package com.ycwh.demo.chapter2;

public class JdkProxyTest
{
    @SuppressWarnings("unchecked")
    public void testJdkProxy()
    {
        JdkProxyExample<HelloWorld> jdk = new JdkProxyExample();
        HelloWorld proxy = jdk.bind(new HelloWorldImp());
        proxy.sayHelloWorld();
    }
}
