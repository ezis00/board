package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.Map;

public class ChannelOptionMap
{
    private Map<ChannelOptionKey, String> channelOptionMap;

    public ChannelOptionMap()
    {
        this.channelOptionMap = new HashMap<>();
    }

    public String get(ChannelOptionKey channelOptionKey)
    {
        return this.channelOptionMap.get(channelOptionKey);
    }

    public void put(ChannelOptionKey channelOptionKey, String value)
    {
        this.channelOptionMap.put(channelOptionKey, value);
    }

    public static ChannelOptionMap fromJson(String value)
    {
        return null;
    }
}
