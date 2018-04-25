package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum VoteType
{
    LOVE, LIKE, DISLIKE, HAPPY, SAD;

    public static VoteType fromJson(String value)
    {
        return JsonUtil.fromJson(value, VoteType.class);
    }
}
