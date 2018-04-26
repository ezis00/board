package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum ChannelOptionKey implements ValueObject
{
    PRIVATE,                // 공개 여부
    ATTACH_MAX_SIZE_MB,     // 첨부파일 최대 크기
    THUMBNAIL_IMAGE_ID,     // 대표 이미지 파일명
    BACKGROUND_IMAGE_ID;    // 바탕 이미지 파일명

    public static ChannelOptionKey fromJson(String value)
    {
        return JsonUtil.fromJson(value, ChannelOptionKey.class);
    }

    public static String toJson(ChannelOptionKey object)
    {
        return JsonUtil.toJson(object);
    }
}
