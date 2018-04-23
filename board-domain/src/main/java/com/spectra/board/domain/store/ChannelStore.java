package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Channel;

public interface ChannelStore
{
    Channel retrieveByTitle(String title);

    void create(Channel channel);

    Channel retrieve(String channelId);

    void update(Channel channel);
}
