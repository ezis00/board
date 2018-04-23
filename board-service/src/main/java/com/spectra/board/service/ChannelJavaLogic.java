package com.spectra.board.service;

import com.spectra.board.domain.logic.ChannelLogic;
import com.spectra.board.store.map.ChannelMapStore;

public class ChannelJavaLogic extends ChannelLogic
{
    public ChannelJavaLogic()
    {
        super(new ChannelMapStore());
    }
}
