package com.spectra.board.domain.entity;

import java.util.List;
import java.util.Set;

import com.spectra.board.domain.granule.Attach;
import com.spectra.board.domain.granule.BoardAttachSet;
import com.spectra.board.domain.granule.BoardOptionKey;
import com.spectra.board.domain.granule.BoardOptionMap;
import com.spectra.board.domain.granule.BoardTagIdSet;
import com.spectra.board.domain.granule.BoardViewerIdSet;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;

public class Board extends Post
{
    private String channelId;
    private String title;
    private BoardOptionMap optionMap;
    private BoardAttachSet attachSet;
    private BoardViewerIdSet viewerIdSet;
    private BoardTagIdSet tagIdSet;
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
        this.optionMap = new BoardOptionMap();
        this.attachSet = new BoardAttachSet();
        this.viewerIdSet = new BoardViewerIdSet();
        this.tagIdSet = new BoardTagIdSet();
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

    public void addBoardOption(BoardOptionKey boardOptionKey, String value)
    {
        this.optionMap.put(boardOptionKey, value);
    }

    public String getBoardOption(BoardOptionKey boardOptionKey)
    {
        return this.optionMap.get(boardOptionKey);
    }

    public void addAttach(Attach attach)
    {
        this.attachSet.add(attach);
    }

    public List<Attach> getAttachList()
    {
        return attachSet.getAll();
    }

    public void addViewUserId(String viewUserId)
    {
        this.viewerIdSet.add(viewUserId);
        this.viewCount++;
    }

    public Set<String> getViewUserIdSet()
    {
        return viewerIdSet.getAll();
    }

    public void addTagId(String tagId)
    {
        this.tagIdSet.add(tagId);
    }

    public Set<String> getTagIdSet()
    {
        return this.tagIdSet.getAll();
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
                ", optionMap=" + optionMap +
                ", attachSet=" + attachSet +
                ", viewerIdSet=" + viewerIdSet +
                ", tagIdSet=" + tagIdSet +
                ", viewCount=" + viewCount +
                "} " + super.toString();
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
                case "optionMap":
                    this.optionMap = BoardOptionMap.fromJson(value);
                    break;
                default:
                    super.setValues(nameValueList);
            }
        }
    }
}
