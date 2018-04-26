package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Scrap;

public interface ScrapStore
{
    void create(Scrap scrap);

    Scrap retrieve(String scrapId);

    void update(Scrap scrap);
}
