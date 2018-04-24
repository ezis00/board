package com.spectra.board.domain.entity;

import java.util.UUID;

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

    @Override
    public String toString()
    {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }
}
