package com.ycwh.demo.chapter5;

public enum SexEnum
{
    Female(0, "女"), Male(1, "男");

    private int index;
    private String sex;

    SexEnum(int index, String sex)
    {
        this.index = index;
        this.sex = sex;
    }

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }
}
