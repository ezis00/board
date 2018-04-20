package com.spectra.board.domain.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.spectra.board.domain.granule.Attach;
import com.spectra.board.domain.granule.BoardOptionKey;

public class Board extends Post
{
    private String title;
    private String surveyId;
    private Map<BoardOptionKey, String> boardOptionMap;
    private List<Attach> attachList;
    private Set<String> viewUserIdSet;
    private int viewCount;

    public Board()
    {
    }

    public Board(String id)
    {
        super(id);
    }

    public Board(String title, String contents, String writeUserId)
    {
        super(contents, writeUserId);
        this.title = title;
        this.attachList = new ArrayList<Attach>();
        this.viewUserIdSet = new HashSet<String>();
        this.viewCount = 0;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getSurveyId()
    {
        return surveyId;
    }

    public void setSurveyId(String surveyId)
    {
        this.surveyId = surveyId;
    }

    public void addBoardOption(BoardOptionKey boardOptionKey, String value)
    {
        this.boardOptionMap.put(boardOptionKey, value);
    }

    public String getBoardOption(BoardOptionKey boardOptionKey)
    {
        return this.boardOptionMap.get(boardOptionKey);
    }

    public void addAttach(Attach attach)
    {
        this.attachList.add(attach);
    }

    public List<Attach> getAttachList()
    {
        return attachList;
    }

    public void addViewUserId(String viewUserId)
    {
        this.viewUserIdSet.add(viewUserId);
        this.viewCount++;
    }

    public Set<String> getViewUserIdSet()
    {
        return viewUserIdSet;
    }

    public int getViewCount()
    {
        return viewCount;
    }

    public void setViewCount(int viewCount)
    {
        this.viewCount = viewCount;
    }

    @Override
    public String toString()
    {
        return "Board{" +
                "title='" + title + '\'' +
                ", contents='" + getContents() + '\'' +
                ", postDate=" + getPostDate() +
                ", writeUserId='" + getWriteUserId() + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", attachList='" + attachList + '\'' +
                ", viewUserIdSet=" + viewUserIdSet +
                ", viewCount=" + viewCount +
                ", boardOptionMap=" + boardOptionMap +
                '}';
    }
}
