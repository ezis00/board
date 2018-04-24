package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Tag;
import com.spectra.board.domain.spec.TagService;
import com.spectra.board.domain.store.TagStore;

public class TagLogic implements TagService
{
    private TagStore tagStore;

    public TagLogic(TagStore tagStore)
    {
        this.tagStore = tagStore;
    }

    @Override
    public String register(Tag tag)
    {
        tagStore.create(tag);
        return tag.getId();
    }

    @Override
    public Tag find(String tagId)
    {
        return tagStore.retrieve(tagId);
    }
}
