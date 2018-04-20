package com.spectra.board.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spectra.board.domain.granule.Level;
import com.spectra.board.domain.granule.NotifyOptionKey;

public class Notify extends Entity
{
    private String boardId;
    private String startDate;
    private String endDate;
    private List<Level> levelList;
    private Map<NotifyOptionKey, String> notifyOptionMap;

    public Notify()
    {
    }

    public Notify(String id)
    {
        super(id);
    }

    public Notify(String boardId, String startDate, String endDate, List<Level> levelList)
    {
        this.boardId = boardId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.levelList = levelList;
        this.notifyOptionMap = new HashMap<NotifyOptionKey, String>();
    }

    public String getBoardId()
    {
        return boardId;
    }

    public void setBoardId(String boardId)
    {
        this.boardId = boardId;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

    public List<Level> getLevelList()
    {
        return levelList;
    }

    public void setLevelList(List<Level> levelList)
    {
        this.levelList = levelList;
    }

    public void addNotifyOption(NotifyOptionKey notifyOptionKey, String value){
        this.notifyOptionMap.put(notifyOptionKey, value);
    }

    public String getNotifyOption(NotifyOptionKey notifyOptionKey)
    {
        return this.notifyOptionMap.get(notifyOptionKey);
    }

    @Override
    public String toString()
    {
        return "Notify{" +
                "boardId='" + boardId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", levelList=" + levelList +
                ", notifyOptionMap=" + notifyOptionMap +
                '}';
    }
}
