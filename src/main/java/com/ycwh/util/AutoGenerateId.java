package com.ycwh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoGenerateId
{
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yymmddhhmm");

    public static int getAutoGenerateId()
    {
        return Integer.parseInt(simpleDateFormat.format(new Date()));
    }

}
