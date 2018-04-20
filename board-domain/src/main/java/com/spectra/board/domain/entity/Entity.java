package com.spectra.board.domain.entity;

import java.util.UUID;

public class Entity
{
    private final String id;

    public Entity()
    {
        this.id = UUID.randomUUID().toString();
    }

    public Entity(String id)
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
