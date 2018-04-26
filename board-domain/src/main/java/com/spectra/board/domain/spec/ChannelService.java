package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.share.granule.NameValueList;

public interface ChannelService
{
    String register(Channel channel);

    Channel find(String channelId);

    Channel findByTitle(String title);

    void modify(String channelId, NameValueList nameValueList);
}
