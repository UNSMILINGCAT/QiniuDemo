package com.ycwh.demo.chapter9.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "source")
public class Source
{
    @Value("双皮奶")
    private String fruit;
    @Value("少糖")
    private String sugar;
    @Value("大杯")
    private String size;

    public String getFruit()
    {
        return fruit;
    }

    public void setFruit(String fruit)
    {
        this.fruit = fruit;
    }

    public String getSugar()
    {
        return sugar;
    }

    public void setSugar(String sugar)
    {
        this.sugar = sugar;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }
}
