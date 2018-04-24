package com.spectra.share.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeUtil
{
    public static long getTime(String yyyyMMddHHmmss)
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        try
        {
            return dateFormat.parse(yyyyMMddHHmmss).getTime();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
            return System.currentTimeMillis();
        }
    }
}
