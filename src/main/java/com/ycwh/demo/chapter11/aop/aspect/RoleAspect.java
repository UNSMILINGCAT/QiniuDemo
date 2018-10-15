package com.ycwh.demo.chapter11.aop.aspect;

import com.ycwh.demo.chapter11.aop.service.RoleVerifier;
import com.ycwh.demo.chapter11.aop.service.RoleVerifierImpl;
import com.ycwh.pojo.Role;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class RoleAspect
{
    @DeclareParents(value = "com.ycwh.demo.chapter11.aop.service.RoleServiceImpl+", defaultImpl = RoleVerifierImpl
            .class)
    public RoleVerifier roleVerifier;

    @Pointcut("execution(* com.ycwh.demo.chapter11.aop.service.RoleServiceImpl.printRole(..))" + "&& args(role)")
    public void print1(Role role) {}

    @Pointcut("execution(* com.ycwh.demo.chapter11.aop.service.RoleServiceImpl.printRole(..))")
    public void print() {}

    @Before("print1(role)")
    public void before(Role role)
    {
        System.out.println("before ...." + role.getRoleName());
    }

    @Around("print1(role)")
    public void around(ProceedingJoinPoint jp, Role role)
    {
        System.out.println("around before ...");
        try
        {
            jp.proceed();
        } catch (Throwable throwable)
        {
            throwable.printStackTrace();
        }
        System.out.println("around after...");
    }

    @After("print1(role)")
    public void after(Role role)
    {
        System.out.println("After...");
    }

    @AfterReturning("print1(role)")
    public void AfterReturning(Role role)
    {
        System.out.println("AfterReturning...");
    }

    @AfterThrowing("print1(role)")
    public void AfterThrowing(Role role)
    {
        System.out.println("AfterThrowing...");
    }
}
