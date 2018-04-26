package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Scrap;
import com.spectra.board.domain.spec.ScrapService;
import com.spectra.board.domain.store.ScrapStore;

public class ScrapLogic implements ScrapService
{
    private ScrapStore scrapStore;

    public ScrapLogic(ScrapStore scrapStore)
    {
        this.scrapStore = scrapStore;
    }

    @Override
    public String register(Scrap scrap)
    {
        scrapStore.create(scrap);
        return scrap.getId();
    }

    @Override
    public Scrap find(String scrapId)
    {
        return scrapStore.retrieve(scrapId);
    }
}
