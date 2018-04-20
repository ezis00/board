package com.spectra.board.domain.entity;

import java.util.List;
import java.util.Map;

import com.spectra.board.domain.granule.ChannelOptionKey;

public class Channel extends Entity
{
    private Map<ChannelOptionKey, String> channelOptionMap;
    private List<String> boardIdList;
    private List<String> memberUserIdList;
}
