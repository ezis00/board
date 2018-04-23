package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.store.ChannelStore;

public class ChannelMapStore implements ChannelStore
{
    private Map<String, Channel> channelMap;

    public ChannelMapStore()
    {
        this.channelMap = new HashMap<>();
    }

    @Override
    public Channel retrieveByTitle(String title)
    {
        return this.channelMap.values().stream().filter(channel -> channel.getTitle().equals(title)).findFirst().orElse(null);
    }

    @Override
    public void create(Channel channel)
    {
        this.channelMap.put(channel.getId(), channel);
    }

    @Override
    public Channel retrieve(String channelId)
    {
        return this.channelMap.get(channelId);
    }

    @Override
    public void update(Channel channel)
    {
        this.channelMap.put(channel.getId(), channel);
    }
}
