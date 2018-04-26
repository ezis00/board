package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum UserType
{
    ADMIN, MANAGER, USER;

    public static UserType fromJson(String value)
    {
        return JsonUtil.fromJson(value, UserType.class);
    }

    public static String toJson(UserType object)
    {
        return JsonUtil.toJson(object);
    }
}
