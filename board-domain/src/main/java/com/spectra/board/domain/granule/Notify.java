package com.spectra.board.domain.granule;

import java.util.List;

import com.spectra.share.util.JsonUtil;

public class Notify implements ValueObject
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

    public static Notify fromJson(String value)
    {
        return JsonUtil.fromJson(value, Notify.class);
    }

    public static String toJson(Notify object)
    {
        return JsonUtil.toJson(object);
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notify notify = (Notify) o;

        if (startDate != null ? !startDate.equals(notify.startDate) : notify.startDate != null) return false;
        if (endDate != null ? !endDate.equals(notify.endDate) : notify.endDate != null) return false;
        if (levelList != null ? !levelList.equals(notify.levelList) : notify.levelList != null) return false;
        return notifyOptionMap != null ? notifyOptionMap.equals(notify.notifyOptionMap) : notify.notifyOptionMap == null;
    }

    @Override
    public int hashCode()
    {
        int result = startDate != null ? startDate.hashCode() : 0;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (levelList != null ? levelList.hashCode() : 0);
        result = 31 * result + (notifyOptionMap != null ? notifyOptionMap.hashCode() : 0);
        return result;
    }
}
