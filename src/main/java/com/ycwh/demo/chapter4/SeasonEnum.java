package com.ycwh.demo.chapter4;

public enum SeasonEnum
{
    SPRING("春天");
    private String name;

    SeasonEnum(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
