package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Tag;
import com.spectra.board.domain.store.TagStore;

public class TagMapStore implements TagStore
{
    private Map<String, Tag> map;

    public TagMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Tag tag)
    {
        this.map.put(tag.getId(), tag);
    }

    @Override
    public Tag retrieve(String tagId)
    {
        return this.map.get(tagId);
    }

    @Override
    public void update(Tag tag)
    {
        this.map.put(tag.getId(), tag);
    }
}
