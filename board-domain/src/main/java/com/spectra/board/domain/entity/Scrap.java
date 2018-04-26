package com.spectra.board.domain.entity;

import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;

public class Scrap extends Entity
{
    private final PostInfo postInfo;
    private final String userId;
    private final long date;

    public Scrap(PostInfo postInfo, String userId, long date)
    {
        this.postInfo = postInfo;
        this.userId = userId;
        this.date = date;
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

    @Override
    public void setValues(NameValueList nameValueList)
    {

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
}
