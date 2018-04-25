package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.NameValueList;

public class Tag extends Entity
{
    private final String name;
    private final long createdDate;

    public Tag(String name)
    {
        super();
        this.name = name;
        this.createdDate = System.currentTimeMillis();
    }

    @Override
    public void setValues(NameValueList nameValueList)
    {

    }

    public String getName()
    {
        return name;
    }

    public long getCreatedDate()
    {
        return createdDate;
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
