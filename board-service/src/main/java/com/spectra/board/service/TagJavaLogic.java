package com.spectra.board.service;

import com.spectra.board.domain.logic.TagLogic;
import com.spectra.board.store.map.TagMapStore;

public class TagJavaLogic extends TagLogic
{
    public TagJavaLogic()
    {
        super(new TagMapStore());
    }
}
