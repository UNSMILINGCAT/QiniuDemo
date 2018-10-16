package com.ycwh.pojo;

import com.ycwh.demo.chapter14.pojo.PageParams;

public class Role
{
    private int id;
    private String roleName;
    private String note;
    private PageParams pageParams = null;

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

    public PageParams getPageParams()
    {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams)
    {
        this.pageParams = pageParams;
    }
}
