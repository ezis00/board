package com.spectra.board.domain.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.spectra.board.domain.granule.Attach;
import com.spectra.board.domain.granule.BoardOptionKey;
import com.spectra.board.domain.granule.BoardOptionMap;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;

public class Board extends Post
{
    private String channelId;
    private String title;
    private String surveyId;
    private BoardOptionMap boardOptionMap;
    private List<Attach> attachList;
    private Set<String> viewUserIdSet;
    private Set<String> tagIdSet;
    private int viewCount;

    public Board()
    {
    }

    public Board(String id)
    {
        super(id);
    }

    public Board(String channelId, String title, String contents, String writeUserId)
    {
        super(contents, writeUserId);
        this.channelId = channelId;
        this.title = title;
        this.boardOptionMap = new BoardOptionMap();
        this.attachList = new ArrayList<>();
        this.viewUserIdSet = new HashSet<>();
        this.tagIdSet = new HashSet<>();
        this.viewCount = 0;
    }

    public String getChannelId()
    {
        return channelId;
    }

    public void setChannelId(String channelId)
    {
        this.channelId = channelId;
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

    public void addTagId(String tagId)
    {
        this.tagIdSet.add(tagId);
    }

    public Set<String> getTagIdSet()
    {
        return this.tagIdSet;
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
                "channelId='" + channelId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + getContents() + '\'' +
                ", postDate=" + getPostDate() +
                ", writeUserId='" + getWriteUserId() + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", attachList='" + attachList + '\'' +
                ", viewUserIdSet=" + viewUserIdSet +
                ", tagIdSet=" + tagIdSet +
                ", viewCount=" + viewCount +
                ", boardOptionMap=" + boardOptionMap +
                '}';
    }

    @Override
    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "channelId":
                    this.channelId = value;
                    break;
                case "title":
                    this.title = value;
                    break;
                case "surveyId":
                    this.surveyId = value;
                    break;
                case "boardOptionMap":
                    this.boardOptionMap = BoardOptionMap.fromJson(value);
                    break;
                default:
                    super.setValues(nameValueList);
            }
        }
    }
}
