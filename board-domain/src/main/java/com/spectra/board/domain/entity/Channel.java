package com.spectra.board.domain.entity;

import java.util.List;

import com.spectra.board.domain.granule.ChannelMemberIdList;
import com.spectra.board.domain.granule.ChannelOptionKey;
import com.spectra.board.domain.granule.ChannelOptionMap;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;

public class Channel extends Entity
{
    private String title;
    private ChannelOptionMap channelOptionMap;
    private ChannelMemberIdList channelMemberIdList;

    public Channel()
    {
    }

    public Channel(String title)
    {
        this.title = title;
        this.channelOptionMap = new ChannelOptionMap();
        this.channelMemberIdList = new ChannelMemberIdList();
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

    public List<String> getMemberIdList()
    {
        return channelMemberIdList.getAll();
    }

    public void addMemberId(String memberId)
    {
        this.channelMemberIdList.add(memberId);
    }

    public void setMemberIdList(ChannelMemberIdList channelMemberIdList)
    {
        this.channelMemberIdList = channelMemberIdList;
    }

    @Override
    public String toString()
    {
        return "Channel{" +
                "title='" + title + '\'' +
                ", channelOptionMap=" + channelOptionMap +
                ", channelMemberIdList=" + channelMemberIdList +
                "} " + super.toString();
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
                case "channelMemberIdList":
                    this.channelMemberIdList = ChannelMemberIdList.fromJson(value);
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
