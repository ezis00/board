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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SurveyAnswer that = (SurveyAnswer) o;

        if (surveyAnswerType != that.surveyAnswerType) return false;
        return contents != null ? contents.equals(that.contents) : that.contents == null;
    }

    @Override
    public int hashCode()
    {
        int result = surveyAnswerType != null ? surveyAnswerType.hashCode() : 0;
        result = 31 * result + (contents != null ? contents.hashCode() : 0);
        return result;
    }
}
