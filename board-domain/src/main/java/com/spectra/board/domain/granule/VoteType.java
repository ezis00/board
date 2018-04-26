package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum VoteType implements ValueObject
{
    LOVE, LIKE, DISLIKE, HAPPY, SAD;

    public static VoteType fromJson(String value)
    {
        return JsonUtil.fromJson(value, VoteType.class);
    }

    public static String toJson(VoteType object)
    {
        return JsonUtil.toJson(object);
    }
}
