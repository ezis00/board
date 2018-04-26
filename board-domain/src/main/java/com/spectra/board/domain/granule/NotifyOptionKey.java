package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum NotifyOptionKey implements ValueObject
{
    REPORT_ME_FLAG; //나에게 알림

    public static NotifyOptionKey fromJson(String value)
    {
        return JsonUtil.fromJson(value, NotifyOptionKey.class);
    }

    public static String toJson(NotifyOptionKey object)
    {
        return JsonUtil.toJson(object);
    }
}
