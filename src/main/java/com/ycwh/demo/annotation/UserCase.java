package com.ycwh.demo.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase
{
    public String value();
    public String description() default "这是一个自定义注解";
}
