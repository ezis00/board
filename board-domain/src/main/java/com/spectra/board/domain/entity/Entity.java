package com.spectra.board.domain.entity;

import java.util.UUID;

import com.spectra.board.domain.share.granule.NameValueList;

public abstract class Entity
{
    private final String id;

    protected Entity()
    {
        this.id = UUID.randomUUID().toString();
    }

    protected Entity(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public abstract void setValues(NameValueList nameValueList);

    @Override
    public String toString()
    {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }
}
