package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Notify;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.spec.NotifyService;
import com.spectra.board.domain.store.NotifyStore;

public class NotifyLogic implements NotifyService
{
    private NotifyStore notifyStore;

    public NotifyLogic(NotifyStore notifyStore)
    {
        this.notifyStore = notifyStore;
    }

    @Override
    public String register(Notify notify)
    {
        notifyStore.create(notify);
        return notify.getId();
    }

    @Override
    public Notify find(String notifyId)
    {
        return notifyStore.retrieve(notifyId);
    }
}
