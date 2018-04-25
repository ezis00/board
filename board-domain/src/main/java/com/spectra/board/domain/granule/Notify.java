package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.spectra.board.domain.granule.Level;
import com.spectra.board.domain.granule.NotifyOptionKey;
import com.spectra.board.domain.granule.PostInfo;

public class Notify
{
    private final String startDate;
    private final String endDate;
    private final List<Level> levelList;
    private final Map<NotifyOptionKey, String> notifyOptionMap;

    public Notify(String startDate, String endDate, List<Level> levelList)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.levelList = levelList;
        this.notifyOptionMap = new HashMap<>();
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
                "startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", levelList=" + levelList +
                ", notifyOptionMap=" + notifyOptionMap +
                '}';
    }
}
