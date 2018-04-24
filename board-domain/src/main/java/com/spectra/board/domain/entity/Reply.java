package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public class Reply extends Post
{
    private final PostType postType = PostType.REPLY;

    protected Reply(PostInfo parentPostInfo, String writeUserId)
    {
        super(parentPostInfo, writeUserId);
    }

    @Override
    public PostType getPostType()
    {
        return this.postType;
    }

    @Override
    public String toString()
    {
        return "Reply{} " + super.toString();
    }
}
