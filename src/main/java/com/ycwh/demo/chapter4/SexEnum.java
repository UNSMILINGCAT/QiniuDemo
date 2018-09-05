package com.ycwh.demo.chapter4;

public enum SexEnum
{
    MALE("男"), FEMALE("女");
    private final String sex;

    SexEnum(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
}
