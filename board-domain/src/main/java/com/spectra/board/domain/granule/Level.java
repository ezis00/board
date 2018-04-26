package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum  Level
{
    EMAIL, SMS;

    public static Level fromJson(String value)
    {
        return JsonUtil.fromJson(value, Level.class);
    }

    public static String toJson(Level object)
    {
        return JsonUtil.toJson(object);
    }
}
