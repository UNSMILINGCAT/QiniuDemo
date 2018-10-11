package com.ycwh.demo.chapter14.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 使用注解的方式配置IoC容器
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
    @Override
    protected Class<?>[] getRootConfigClasses()
    {
        return new Class[]{};
    }

    @Override
    protected Class<?>[] getServletConfigClasses()
    {
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings()
    {
        return new String[]{"*.do"};
    }
}
