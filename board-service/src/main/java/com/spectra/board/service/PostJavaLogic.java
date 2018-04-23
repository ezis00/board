package com.spectra.board.service;

import com.spectra.board.domain.logic.PostLogic;
import com.spectra.board.store.map.PostMapStore;

public class PostJavaLogic extends PostLogic
{
    public PostJavaLogic()
    {
        super(new PostMapStore());
    }
}
