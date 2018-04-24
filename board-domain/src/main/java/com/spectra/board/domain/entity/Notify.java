package com.spectra.board.domain.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spectra.board.domain.granule.Level;
import com.spectra.board.domain.granule.NotifyOptionKey;
import com.spectra.board.domain.granule.PostInfo;

public class Notify extends Entity
{
    private final PostInfo parentPostInfo;
    private final String startDate;
    private final String endDate;
    private final List<Level> levelList;
    private final Map<NotifyOptionKey, String> notifyOptionMap;

    public Notify(PostInfo parentPostInfo, String startDate, String endDate, List<Level> levelList)
    {
        super();
        this.parentPostInfo = parentPostInfo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.levelList = levelList;
        this.notifyOptionMap = new HashMap<>();
    }

    public PostInfo getParentPostInfo()
    {
        return parentPostInfo;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public String getEndDate()
    {
        return endDate;
    }

    public List<Level> getLevelList()
    {
        return levelList;
    }

    public void addNotifyOption(NotifyOptionKey notifyOptionKey, String value){
        this.notifyOptionMap.put(notifyOptionKey, value);
    }

    @Override
    public String toString()
    {
        return "Notify{" +
                "parentPostInfo=" + parentPostInfo +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", levelList=" + levelList +
                ", notifyOptionMap=" + notifyOptionMap +
                "} " + super.toString();
    }
}
