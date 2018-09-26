package com.ycwh.demo.chapter10.annotation.comfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan(basePackages = {"com.ycwh.demo.chapter10.annotation"})
@ImportResource({"chapter10/spring-dataSource.xml"})
public class ApplicationConfig
{

}
