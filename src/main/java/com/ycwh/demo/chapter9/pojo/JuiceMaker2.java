package com.ycwh.demo.chapter9.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component(value = "juiceMaker2")
@ComponentScan(basePackageClasses = {Source.class})
public class JuiceMaker2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean
{
    @Value("饮料")
    private String beverageShop = null;
    @Autowired
    private Source source = null;

    public String getBeverageShop()
    {
        return beverageShop;
    }

    public void setBeverageShop(String beverageShop)
    {
        this.beverageShop = beverageShop;
    }

    public Source getSource()
    {
        return source;
    }

    public void setSource(Source source)
    {
        this.source = source;
    }

    public void init()
    {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义初始化方法");
    }

    public void destroy()
    {
        System.out.println("【" + this.getClass().getSimpleName() + "】执行自定义销毁方法");
    }

    public String makeJuice()
    {
        String juice = "这是一杯由" + beverageShop + "饮品店，提供的" + source.getSize() + source.getSugar() + source.getFruit();
        return juice;
    }

    @Override
    public void setBeanName(String s)
    {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanNameAware接口的setBeanName方法");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException
    {
        System.out.println("【" + this.getClass().getSimpleName() + "】调用BeanFactoryAware接口的setBeanFactory方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        System.out.println("【" + this.getClass().getSimpleName() +
                "】调用InitializingBean接口的afterPropertiesSet方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        System.out.println("【" + this.getClass().getSimpleName() +
                "】调用ApplicationContextAware接口的setApplicationContext方法");
    }
}
