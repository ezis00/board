package com.spectra.board.domain.entity;

import com.spectra.board.domain.entity.board.Posting;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;

public class Tag extends Entity
{
    private final String name;
    private final long createdDate;

    transient private Posting posting;

    public Tag(String name)
    {
        super();
        this.name = name;
        this.createdDate = System.currentTimeMillis();
    }

    public static Tag getSample()
    {
        return new Tag("기타");
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

    @Override
    public void setValues(NameValueList nameValueList)
    {
        for (NameValue nameValue : nameValueList.getList())
        {
            switch (nameValue.getName())
            {
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
