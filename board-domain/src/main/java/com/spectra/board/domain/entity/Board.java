package com.spectra.board.domain.entity;

import java.util.List;

public class Board extends Entity
{
    private int sequence;
    private String title;
    private String contents;
    private long date;
    private String writeUserId;
    private String surveyId;
    private String attachId;
    private List<String> viewUserIdList;

    public Board()
    {
    }

    public Board(String id)
    {
        super(id);
    }

    public Board(int sequence, String title, String contents, String writeUserId)
    {
        this.sequence = sequence;
        this.title = title;
        this.contents = contents;
        this.writeUserId = writeUserId;
        this.date = System.currentTimeMillis();
    }

    public int getSequence()
    {
        return sequence;
    }

    public void setSequence(int sequence)
    {
        this.sequence = sequence;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContents()
    {
        return contents;
    }

    public void setContents(String contents)
    {
        this.contents = contents;
    }

    public long getDate()
    {
        return date;
    }

    public void setDate(long date)
    {
        this.date = date;
    }

    public String getWriteUserId()
    {
        return writeUserId;
    }

    public void setWriteUserId(String writeUserId)
    {
        this.writeUserId = writeUserId;
    }

    public String getSurveyId()
    {
        return surveyId;
    }

    public void setSurveyId(String surveyId)
    {
        this.surveyId = surveyId;
    }

    public String getAttachId()
    {
        return attachId;
    }

    public void setAttachId(String attachId)
    {
        this.attachId = attachId;
    }

    public List<String> getViewUserIdList()
    {
        return viewUserIdList;
    }

    public void setViewUserIdList(List<String> viewUserIdList)
    {
        this.viewUserIdList = viewUserIdList;
    }

    @Override
    public String toString()
    {
        return "Board{" +
                "sequence=" + sequence +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", date=" + date +
                ", writeUserId='" + writeUserId + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", attachId='" + attachId + '\'' +
                ", viewUserIdList=" + viewUserIdList +
                '}';
    }
}
