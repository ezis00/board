package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum SurveyAnswerType implements ValueObject
{
    DATE, TIME, TEXT, IMAGE;

    public static SurveyAnswerType fromJson(String value)
    {
        return JsonUtil.fromJson(value, SurveyAnswerType.class);
    }

    public static String toJson(SurveyAnswerType object)
    {
        return JsonUtil.toJson(object);
    }
}
