package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.spec.ChannelService;
import com.spectra.board.domain.store.ChannelStore;

public class ChannelLogic implements ChannelService
{
    private ChannelStore channelStore;

    public ChannelLogic(ChannelStore channelStore)
    {
        this.channelStore = channelStore;
    }

    @Override
    public String register(Channel channel)
    {
        if (channelStore.retrieveByTitle(channel.getName()) != null)
        {
            throw new RuntimeException("Already Exist title:" + channel.getName());
        }
        channelStore.create(channel);
        return channel.getId();
    }

    @Override
    public Channel find(String channelId)
    {
        return channelStore.retrieve(channelId);
    }

    @Override
    public Channel findByTitle(String title)
    {
        return channelStore.retrieveByTitle(title);
    }

    @Override
    public void modify(String channelId, NameValueList nameValueList)
    {
        Channel channel = find(channelId);
        channel.setValues(nameValueList);
        channelStore.update(channel);
    }
}
