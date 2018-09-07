package com.ycwh.demo.chapter4.POJO;

import com.ycwh.demo.chapter4.SexEnum;

public class Dinosaur
{
    private Long id;
    private String dinosaurName;
    private SexEnum sex;
    private int lv;

    public Long getId()
    {
        return id;
    }

    public String getDinosaurName()
    {
        return dinosaurName;
    }

    public void setDinosaurName(String dinosaurName)
    {
        this.dinosaurName = dinosaurName;
    }

    public SexEnum getSex()
    {
        return sex;
    }

    public void setSex(SexEnum sex)
    {
        this.sex = sex;
    }

    public int getLv()
    {
        return lv;
    }

    public void setLv(int lv)
    {
        this.lv = lv;
    }
}
