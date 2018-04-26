package com.spectra.board.domain.granule;

import java.util.List;

public class Notify
{
    private final String startDate;
    private final String endDate;
    private final List<Level> levelList;
    private final NotifyOptionMap notifyOptionMap;

    public Notify(String startDate, String endDate, List<Level> levelList)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.levelList = levelList;
        this.notifyOptionMap = new NotifyOptionMap();
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

    public void addNotifyOption(NotifyOptionKey notifyOptionKey, String value)
    {
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
