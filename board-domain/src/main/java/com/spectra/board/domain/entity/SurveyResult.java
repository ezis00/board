package com.spectra.board.domain.entity;

import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;

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

    public static SurveyResult getSample()
    {
        return new SurveyResult(Survey.getWhatSample().getId(), User.getAdminSample().getId(), Survey.getWhatSample().getAnswerSet().getAll().iterator().next().getContents());
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

    @Override
    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            switch (nameValue.getName())
            {
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
