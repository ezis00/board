package com.spectra.board.domain.entity;

import java.util.Optional;

import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public class Reply extends Entity
{
    private final PostType postType = PostType.REPLY;
    private final Optional<PostInfo> parentPostInfo;
    private final String writerId;
    private final long postDate;
    private String contents;
    private long lastUpdateDate;

    public Reply(PostInfo parentPostInfo, String writerId, long postDate)
    {
        this.parentPostInfo = Optional.ofNullable(parentPostInfo);
        this.writerId = writerId;
        this.postDate = postDate;
    }

    public PostType getPostType()
    {
        return this.postType;
    }

    public PostInfo getCurrentPostInfo()
    {
        return new PostInfo(getPostType(), getId());
    }

    public Optional<PostInfo> getParentPostInfo()
    {
        return parentPostInfo;
    }

    public String getWriterId()
    {
        return writerId;
    }

    public long getPostDate()
    {
        return postDate;
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
