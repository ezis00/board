package com.spectra.board.domain.granule;

public class SurveyAnswer
{
    private final SurveyAnswerType surveyAnswerType;
    private final String contents;

    public SurveyAnswer(SurveyAnswerType surveyAnswerType, String contents)
    {
        this.surveyAnswerType = surveyAnswerType;
        this.contents = contents;
    }

    public SurveyAnswerType getSurveyAnswerType()
    {
        return surveyAnswerType;
    }

    public String getContents()
    {
        return contents;
    }

    @Override
    public String toString()
    {
        return "SurveyAnswer{" +
                "surveyAnswerType=" + surveyAnswerType +
                ", contents='" + contents + '\'' +
                '}';
    }
}
