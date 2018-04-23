package com.spectra.board.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spectra.board.domain.granule.ChannelOptionKey;
import com.spectra.board.domain.granule.ChannelOptionMap;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;

public class Channel extends Entity
{
    private String title;
    private ChannelOptionMap channelOptionMap;
    private List<String> memberUserIdList;

    public Channel()
    {
    }

    public Channel(String title)
    {
        this.title = title;
        this.channelOptionMap = new ChannelOptionMap();
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

    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "title":
                    this.title = value;
                    break;
                case "channelOptionMap":
                    this.channelOptionMap = ChannelOptionMap.fromJson(value);
                    break;
            }
        }
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
