package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.PostType;
import com.spectra.board.domain.granule.VoteType;

public class Vote extends Entity
{
    private String postId;
    private PostType postType;
    private VoteType voteType;

    public String getPostId()
    {
        return postId;
    }

    public void setPostId(String postId)
    {
        this.postId = postId;
    }

    public PostType getPostType()
    {
        return postType;
    }

    public void setPostType(PostType postType)
    {
        this.postType = postType;
    }

    public VoteType getVoteType()
    {
        return voteType;
    }

    public void setVoteType(VoteType voteType)
    {
        this.voteType = voteType;
    }
}
