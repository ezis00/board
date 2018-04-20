package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.PostType;

public class Reply extends Post
{
    private PostType parentPostType;
    private String parentPostId;

    public Reply()
    {
    }

    public Reply(String id)
    {
        super(id);
    }

    public Reply(String contents, String writeUserId, PostType parentPostType, String parentPostId)
    {
        super(contents, writeUserId);
        this.parentPostType = parentPostType;
        this.parentPostId = parentPostId;
    }

    public PostType getParentPostType()
    {
        return parentPostType;
    }

    public void setParentPostType(PostType parentPostType)
    {
        this.parentPostType = parentPostType;
    }

    public String getParentPostId()
    {
        return parentPostId;
    }

    public void setParentPostId(String parentPostId)
    {
        this.parentPostId = parentPostId;
    }

    @Override
    public String toString()
    {
        return "Reply{" +
                "parentPostType=" + parentPostType +
                ", parentPostId='" + parentPostId + '\'' +
                ", contents='" + getContents() + '\'' +
                ", postDate=" + getPostDate() +
                ", writeUserId='" + getWriteUserId() + '\'' +
                '}';
    }
}
