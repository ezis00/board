package com.spectra.board.domain.entity;

import java.util.List;

import com.spectra.board.domain.granule.SurveyAnswer;
import com.spectra.board.domain.granule.SurveyOptionKey;

public class Survey extends Post
{
    private SurveyOptionKey surveyOptionKey;
    private String title;
    private List<SurveyAnswer> surveyAnswerList;
    private long expiredDate;

    public Survey()
    {
    }

    public Survey(String id)
    {
        super(id);
    }

    public Survey(SurveyOptionKey surveyOptionKey, String title, String contents, String writeUserId, long expiredDate)
    {
        super(contents, writeUserId);
        this.surveyOptionKey = surveyOptionKey;
        this.title = title;
        this.expiredDate = expiredDate;
    }

    public SurveyOptionKey getSurveyOptionKey()
    {
        return surveyOptionKey;
    }

    public void setSurveyOptionKey(SurveyOptionKey surveyOptionKey)
    {
        this.surveyOptionKey = surveyOptionKey;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void addSurveyAnswer(SurveyAnswer surveyAnswer)
    {
        this.surveyAnswerList.add(surveyAnswer);
    }

    public List<SurveyAnswer> getSurveyAnswerList()
    {
        return surveyAnswerList;
    }

    public long getExpiredDate()
    {
        return expiredDate;
    }

    public void setExpiredDate(long expiredDate)
    {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString()
    {
        return "Survey{" +
                "surveyOptionKey=" + surveyOptionKey +
                ", title='" + title + '\'' +
                ", surveyAnswerList=" + surveyAnswerList +
                ", expiredDate=" + expiredDate +
                "} " + super.toString();
    }
}
