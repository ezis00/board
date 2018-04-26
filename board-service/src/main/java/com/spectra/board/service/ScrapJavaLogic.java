package com.spectra.board.service;

import com.spectra.board.domain.logic.ScrapLogic;
import com.spectra.board.store.map.ScrapMapStore;

public class ScrapJavaLogic extends ScrapLogic
{
    public ScrapJavaLogic()
    {
        super(new ScrapMapStore());
    }
}
