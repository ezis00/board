package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.store.ChannelStore;

public class ChannelMapStore implements ChannelStore
{
    private Map<String, Channel> map;

    public ChannelMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public Channel retrieveByTitle(String title)
    {
        return this.map.values().stream().filter(channel -> channel.getName().equals(title)).findFirst().orElse(null);
    }

    @Override
    public void create(Channel channel)
    {
        this.map.put(channel.getId(), channel);
    }

    @Override
    public Channel retrieve(String channelId)
    {
        return this.map.get(channelId);
    }

    @Override
    public void update(Channel channel)
    {
        this.map.put(channel.getId(), channel);
    }
}
