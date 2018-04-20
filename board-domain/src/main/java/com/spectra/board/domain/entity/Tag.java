package com.spectra.board.domain.entity;

public class Tag extends Entity
{
    private String name;
    private long createdDate;

    public Tag()
    {
    }

    public Tag(String name)
    {
        this.name = name;
        this.createdDate = System.currentTimeMillis();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getCreatedDate()
    {
        return createdDate;
    }

    public void setCreatedDate(long createdDate)
    {
        this.createdDate = createdDate;
    }

    @Override
    public String toString()
    {
        return "Tag{" +
                "name='" + name + '\'' +
                ", createdDate=" + createdDate +
                "} " + super.toString();
    }
}
