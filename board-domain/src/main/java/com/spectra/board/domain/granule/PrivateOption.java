package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum PrivateOption implements ValueObject
{
    PRIVATE, PUBLIC, CLOSED;

    public static PrivateOption fromJson(String value)
    {
        return JsonUtil.fromJson(value, PrivateOption.class);
    }

    public static String toJson(PrivateOption object)
    {
        return JsonUtil.toJson(object);
    }
}
