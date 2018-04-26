package com.spectra.board.domain.entity;

import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public class Reply extends Post
{
    private final PostType postType = PostType.REPLY;
    private String contents;
    private long lastUpdateDate;

    public Reply(PostInfo parentPostInfo, String writerId)
    {
        super(parentPostInfo, writerId);
    }

    public PostType getPostType()
    {
        return this.postType;
    }

    public PostInfo getCurrentPostInfo()
    {
        return new PostInfo(getPostType(), getId());
    }

    public String getContents()
    {
        return contents;
    }

    public long getLastUpdateDate()
    {
        return lastUpdateDate;
    }

    @Override
    public String toString()
    {
        return "Reply{} " + super.toString();
    }

    public void setValues(NameValueList nameValueList)
    {
        this.lastUpdateDate = System.currentTimeMillis();
        for (NameValue nameValue : nameValueList.getList())
        {
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "contents":
                    this.contents = value;
                    break;
                default:
                    throw new RuntimeException("Undefined field:" + nameValue.getName());
            }
        }
    }
}
