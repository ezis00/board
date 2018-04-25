package com.spectra.board.service;

import com.spectra.board.domain.logic.BoardLogic;
import com.spectra.board.store.map.BoardMapStore;

public class BoardJavaLogic extends BoardLogic
{
    public BoardJavaLogic()
    {
        super(new BoardMapStore());
    }
}
