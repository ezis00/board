package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.spectra.share.util.JsonUtil;

public class SurveyOptionMap implements ValueObject
{
    private Map<SurveyOptionKey, String> map;

    public SurveyOptionMap()
    {
        this.map = new HashMap<>();
    }

    public SurveyOptionMap(SurveyOptionKey surveyOptionKey, String value)
    {
        this.map.put(surveyOptionKey, value);
    }

    public String get(SurveyOptionKey surveyOptionKey)
    {
        return this.map.get(surveyOptionKey);
    }

    public Map<SurveyOptionKey, String> getAll()
    {
        return this.map;
    }

    public void put(SurveyOptionKey surveyOptionKey, String value)
    {
        this.map.put(surveyOptionKey, value);
    }

    public static SurveyOptionMap fromJson(String value)
    {
        return JsonUtil.fromJson(value, new TypeToken<Map<SurveyOptionKey, String>>() {}.getType());
    }

    public static String toJson(Map<SurveyOptionKey, String> surveyOptionMap)
    {
        return JsonUtil.toJson(surveyOptionMap);
    }

    @Override
    public String toString()
    {
        return "SurveyOptionMap{" +
                "map=" + map +
                '}';
    }
}
