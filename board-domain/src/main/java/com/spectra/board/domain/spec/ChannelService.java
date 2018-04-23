package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Channel;
import com.spectra.board.domain.granule.NameValueList;

public interface ChannelService
{
    String regist(Channel channelCdo);

    Channel find(String channelId);

    Channel findByTitle(String title);

    void modify(String channelId, NameValueList nameValueList);
}
