package com.spectra.board.service;

import com.spectra.board.domain.logic.VoteLogic;
import com.spectra.board.store.map.VoteMapStore;

public class VoteJavaLogic extends VoteLogic
{
    public VoteJavaLogic()
    {
        super(new VoteMapStore());
    }
}
