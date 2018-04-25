package com.spectra.board.service;

import com.spectra.board.domain.logic.ReplyLogic;
import com.spectra.board.store.map.ReplyMapStore;

public class ReplyJavaLogic extends ReplyLogic
{
    public ReplyJavaLogic()
    {
        super(new ReplyMapStore());
    }
}
