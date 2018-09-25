package com.ycwh.demo.chapter10;

public class Role
{
    private String roleName;
    private String note;

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
