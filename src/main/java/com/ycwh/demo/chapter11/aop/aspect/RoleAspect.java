package com.ycwh.demo.chapter11.aop.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class RoleAspect
{
    @Pointcut("execution(* com.ycwh.demo.chapter11.aop.service.RoleServiceImpl.printRole())")
    public void print() {}

    @Before("print()")
    public void before()
    {
        System.out.println("before ....");
    }

    @After("print()")
    public void after() {}

    @AfterReturning("print()")
    public void AfterReturning() {}

    @AfterThrowing("print()")
    public void AfterThrowing() {}
}
