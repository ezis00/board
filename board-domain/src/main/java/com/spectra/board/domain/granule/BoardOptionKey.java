package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum BoardOptionKey implements ValueObject
{
    NOTICE,     // 공지
    PRIVATE;    // 비공개

    public static BoardOptionKey fromJson(String value)
    {
        return JsonUtil.fromJson(value, BoardOptionKey.class);
    }

    public static String toJson(BoardOptionKey object)
    {
        return JsonUtil.toJson(object);
    }
}
