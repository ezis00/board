package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Scrap;

public interface ScrapService
{
    String register(Scrap scrap);

    Scrap find(String scrapId);
}
