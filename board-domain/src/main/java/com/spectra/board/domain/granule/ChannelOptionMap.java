package com.spectra.board.domain.granule;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.spectra.share.util.JsonUtil;

public class ChannelOptionMap
{
    private Map<ChannelOptionKey, String> map;

    public ChannelOptionMap()
    {
        this.map = new HashMap<>();
    }

    public ChannelOptionMap(ChannelOptionKey channelOptionKey, String value)
    {
        this.map.put(channelOptionKey, value);
    }

    public String get(ChannelOptionKey channelOptionKey)
    {
        return this.map.get(channelOptionKey);
    }

    public void put(ChannelOptionKey channelOptionKey, String value)
    {
        this.map.put(channelOptionKey, value);
    }

    public static ChannelOptionMap fromJson(String value)
    {
        return JsonUtil.fromJson(value, new TypeToken<Map<ChannelOptionKey, String>>() {}.getType());
    }

    public static String toJson(Map<ChannelOptionKey, String> channelOptionMap)
    {
        return JsonUtil.toJson(channelOptionMap);
    }

    @Override
    public String toString()
    {
        return "ChannelOptionMap{" +
                "map=" + map +
                '}';
    }
}
