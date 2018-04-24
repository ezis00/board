package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Tag;

public interface TagStore
{
    void create(Tag tag);

    Tag retrieve(String tagId);

    void update(Tag tag);
}
