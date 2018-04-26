package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum AttachType implements ValueObject
{
    TXT, HTM, ZIP, EXE, DOC, JPG, GIF, MPG, WMV, PDF, MP3, WAV;

    public static AttachType fromJson(String value)
    {
        return JsonUtil.fromJson(value, AttachType.class);
    }

    public static String toJson(AttachType object)
    {
        return JsonUtil.toJson(object);
    }
}
