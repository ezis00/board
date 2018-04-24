package com.spectra.board.service;

import com.spectra.board.domain.logic.NotifyLogic;
import com.spectra.board.store.map.NotifyMapStore;

public class NotifyJavaLogic extends NotifyLogic
{
    public NotifyJavaLogic()
    {
        super(new NotifyMapStore());
    }
}
