package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;

public class Scrap extends Entity
{
    private final PostInfo postInfo;
    private final String userId;
    private final long date;

    public Scrap(PostInfo postInfo, String userId)
    {
        this.postInfo = postInfo;
        this.userId = userId;
        this.date = System.currentTimeMillis();
    }

    public PostInfo getPostInfo()
    {
        return postInfo;
    }

    public String getUserId()
    {
        return userId;
    }

    public long getDate()
    {
        return date;
    }

    public static Scrap getSample()
    {
        return new Scrap(Board.getNotifySample().getCurrentPostInfo(), User.getAdminSample().getId());
    }

    @Override
    public String toString()
    {
        return "Scrap{" +
                "postInfo=" + postInfo +
                ", userId='" + userId + '\'' +
                ", date=" + date +
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
