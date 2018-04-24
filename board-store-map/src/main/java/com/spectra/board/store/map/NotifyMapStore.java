package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Notify;
import com.spectra.board.domain.store.NotifyStore;

public class NotifyMapStore implements NotifyStore
{
    private Map<String, Notify> map;

    public NotifyMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Notify notify)
    {
        this.map.put(notify.getId(), notify);
    }

    @Override
    public Notify retrieve(String notifyId)
    {
        return this.map.get(notifyId);
    }

    @Override
    public void update(Notify notify)
    {
        this.map.put(notify.getId(), notify);
    }
}
