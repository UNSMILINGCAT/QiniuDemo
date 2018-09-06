package com.ycwh.demo.chapter4;

public enum SexEnum
{
    MALE(0, "雄性"), FEMALE(1, "雌性");
    private int id;
    private String sex;

    SexEnum(int id, String sex)
    {
        this.sex = sex;
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public static SexEnum getSexById(int id)
    {
        return SexEnum.values()[id];
    }

    public static SexEnum getSexByName(String name)
    {
        if (MALE.name().equals(name))
            return MALE;
        else
        {
            return FEMALE;
        }
    }
}
