package com.ycwh.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutoGenerateId
{
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");

    public static long getAutoGenerateId()
    {
        return Long.parseLong(simpleDateFormat.format(new Date()));
    }

}
