package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Scrap;
import com.spectra.board.domain.store.ScrapStore;

public class ScrapMapStore implements ScrapStore
{
    private Map<String, Scrap> map;

    public ScrapMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Scrap scrap)
    {
        this.map.put(scrap.getId(), scrap);
    }

    @Override
    public Scrap retrieve(String scrapId)
    {
        return this.map.get(scrapId);
    }

    @Override
    public void update(Scrap scrap)
    {
        this.map.put(scrap.getId(), scrap);
    }
}
