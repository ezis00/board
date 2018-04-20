package com.spectra.board.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spectra.board.domain.granule.ChannelOptionKey;

public class Channel extends Entity
{
    private String title;
    private Map<ChannelOptionKey, String> channelOptionMap;
    private List<String> memberUserIdList;

    public Channel()
    {
    }

    public Channel(String title)
    {
        this.title = title;
        this.channelOptionMap = new HashMap<ChannelOptionKey, String>();
        this.memberUserIdList = new ArrayList<String>();
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getChannelOption(ChannelOptionKey channelOptionKey)
    {
        return this.channelOptionMap.get(channelOptionKey);
    }

    public void addChannelOption(ChannelOptionKey channelOptionKey, String value)
    {
        this.channelOptionMap.put(channelOptionKey, value);
    }

    public List<String> getMemberUserIdList()
    {
        return memberUserIdList;
    }

    public void setMemberUserIdList(List<String> memberUserIdList)
    {
        this.memberUserIdList = memberUserIdList;
    }

    @Override
    public String toString()
    {
        return "Channel{" +
                "title='" + title + '\'' +
                ", channelOptionMap=" + channelOptionMap +
                ", memberUserIdList=" + memberUserIdList +
                "} " + super.toString();
    }
}
