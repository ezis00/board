package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Tag;

public interface TagService
{
    String register(Tag tag);

    Tag find(String tagId);
}
