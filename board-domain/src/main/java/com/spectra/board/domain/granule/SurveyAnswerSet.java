package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class SurveyAnswerSet implements ValueObject
{
    private Set<SurveyAnswer> set;

    public SurveyAnswerSet()
    {
        this.set = new HashSet<>();
    }

    public SurveyAnswerSet(SurveyAnswer answer)
    {
        this.set.add(answer);
    }

    public Set<SurveyAnswer> getAll()
    {
        return this.set;
    }

    public void add(SurveyAnswer surveyAnswer)
    {
        this.set.add(surveyAnswer);
    }

    public static SurveyAnswerSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, SurveyAnswerSet.class);
    }

    public static String toJson(SurveyAnswerSet object)
    {
        return JsonUtil.toJson(object);
    }

    @Override
    public String toString()
    {
        return "IdSet{" +
                "set=" + set +
                '}';
    }
}
