package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Notify;

public interface NotifyStore
{
    void create(Notify notify);

    Notify retrieve(String notifyId);

    void update(Notify notify);
}
