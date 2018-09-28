package com.ycwh.demo.chapter10;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "role")
public class Role
{
    @Value("1")
    private int id;
    @Value("roleName")
    private String roleName;
    @Value("note")
    private String note;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Role(String roleName, String note)
    {
        this.roleName = roleName;
        this.note = note;
    }

    public Role()
    {

    }
}
