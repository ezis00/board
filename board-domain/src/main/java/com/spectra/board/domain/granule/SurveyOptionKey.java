package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

public enum SurveyOptionKey
{
    ALLOW_MULTI_SELECT, // 복수 선택 허용
    ALLOW_ANONYMOUS,    // 익명투표 허용
    ALLOW_ADD_ANSWER;   // 선택항목 추가 허용

    public static SurveyOptionKey fromJson(String value)
    {
        return JsonUtil.fromJson(value, SurveyOptionKey.class);
    }

    public static String toJson(SurveyOptionKey object)
    {
        return JsonUtil.toJson(object);
    }
}
