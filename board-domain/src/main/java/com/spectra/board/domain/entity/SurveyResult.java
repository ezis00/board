package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.NameValueList;

public class SurveyResult extends Entity
{
    private final String surveyId;
    private final String userId;
    private final String answerContents;
    private final long date;

    public SurveyResult(String surveyId, String userId, String answerContents)
    {
        super();
        this.surveyId = surveyId;
        this.userId = userId;
        this.answerContents = answerContents;
        this.date = System.currentTimeMillis();
    }

    public String getSurveyId()
    {
        return surveyId;
    }

    public String getUserId()
    {
        return userId;
    }

    public String getAnswerContents()
    {
        return answerContents;
    }

    public long getDate()
    {
        return date;
    }

    @Override
    public void setValues(NameValueList nameValueList)
    {

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
