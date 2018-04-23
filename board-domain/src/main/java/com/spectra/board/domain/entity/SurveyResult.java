package com.spectra.board.domain.entity;

public class SurveyResult extends Entity
{
    private String surveyId;
    private String userId;
    private String answerContents;
    private long date;

    public SurveyResult()
    {
    }

    public SurveyResult(String id)
    {
        super(id);
    }

    public SurveyResult(String surveyId, String userId, String answerContents)
    {
        this.surveyId = surveyId;
        this.userId = userId;
        this.answerContents = answerContents;
        this.date = System.currentTimeMillis();
    }

    public String getSurveyId()
    {
        return surveyId;
    }

    public void setSurveyId(String surveyId)
    {
        this.surveyId = surveyId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAnswerContents()
    {
        return answerContents;
    }

    public void setAnswerContents(String answerContents)
    {
        this.answerContents = answerContents;
    }

    public long getDate()
    {
        return date;
    }

    public void setDate(long date)
    {
        this.date = date;
    }

    @Override
    public String toString()
    {
        return "SurveyResult{" +
                "surveyId='" + surveyId + '\'' +
                ", userId='" + userId + '\'' +
                ", answerContents='" + answerContents + '\'' +
                ", date=" + date +
                "} " + super.toString();
    }
}
