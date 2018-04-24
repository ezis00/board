package com.spectra.board.domain.entity;

import java.util.Set;

import com.spectra.board.domain.granule.ChannelMemberIdSet;
import com.spectra.board.domain.granule.ChannelOptionKey;
import com.spectra.board.domain.granule.ChannelOptionMap;
import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;

public class Channel extends Entity
{
    private final String title;
    private ChannelOptionMap channelOptionMap;
    private ChannelMemberIdSet channelMemberIdSet;

    public Channel(String title)
    {
        super();
        this.title = title;
        this.channelOptionMap = new ChannelOptionMap();
        this.channelMemberIdSet = new ChannelMemberIdSet();
    }

    public String getTitle()
    {
        return title;
    }

    public String getOption(ChannelOptionKey channelOptionKey)
    {
        return this.channelOptionMap.get(channelOptionKey);
    }

    public void addOption(ChannelOptionKey channelOptionKey, String value)
    {
        this.channelOptionMap.put(channelOptionKey, value);
    }

    public Set<String> getMemberIdSet()
    {
        return channelMemberIdSet.getAll();
    }

    public void addMemberId(String memberId)
    {
        this.channelMemberIdSet.add(memberId);
    }

    public void setMemberIdSet(ChannelMemberIdSet channelMemberIdSet)
    {
        this.channelMemberIdSet = channelMemberIdSet;
    }

    @Override
    public String toString()
    {
        return "Channel{" +
                "title='" + title + '\'' +
                ", channelOptionMap=" + channelOptionMap +
                ", channelMemberIdSet=" + channelMemberIdSet +
                "} " + super.toString();
    }

    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "channelOptionMap":
                    this.channelOptionMap = ChannelOptionMap.fromJson(value);
                    break;
                case "channelMemberIdSet":
                    this.channelMemberIdSet = ChannelMemberIdSet.fromJson(value);
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
