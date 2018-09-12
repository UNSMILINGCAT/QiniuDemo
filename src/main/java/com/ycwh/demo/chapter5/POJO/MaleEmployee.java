package com.ycwh.demo.chapter5.POJO;

import java.io.Serializable;

public class MaleEmployee extends Employee implements Serializable
{
    private MaleHealthForm maleHealthForm;

    public MaleHealthForm getMaleHealthForm()
    {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm)
    {
        this.maleHealthForm = maleHealthForm;
    }
}
