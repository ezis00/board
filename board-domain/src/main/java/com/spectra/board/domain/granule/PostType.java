package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum PostType implements ValueObject
{
    CHANNEL, BOARD, SURVEY, REPLY, VOTE;

    public static PostType fromJson(String value)
    {
        return JsonUtil.fromJson(value, PostType.class);
    }

    public static String toJson(PostType object)
    {
        return JsonUtil.toJson(object);
    }
}
