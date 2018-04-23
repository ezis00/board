package com.spectra.board.service;

import com.spectra.board.domain.logic.UserLogic;
import com.spectra.board.store.map.UserMapStore;

public class UserJavaLogic extends UserLogic
{
    public UserJavaLogic()
    {
        super(new UserMapStore());
    }
}
