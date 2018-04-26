package com.spectra.board.domain.granule;

import java.util.HashSet;
import java.util.Set;

import com.spectra.share.util.JsonUtil;

public class SurveyAnswerSet
{
    private Set<SurveyAnswer> answerSet;

    public SurveyAnswerSet()
    {
        this.answerSet = new HashSet<>();
    }

    public SurveyAnswerSet(SurveyAnswer answer)
    {
        this.answerSet.add(answer);
    }

    public Set<SurveyAnswer> getAll()
    {
        return this.answerSet;
    }

    public void add(SurveyAnswer surveyAnswer)
    {
        this.answerSet.add(surveyAnswer);
    }

    public static SurveyAnswerSet fromJson(String value)
    {
        return JsonUtil.fromJson(value, SurveyAnswerSet.class);
    }

    @Override
    public String toString()
    {
        return "IdSet{" +
                "answerSet=" + answerSet +
                '}';
    }
}
