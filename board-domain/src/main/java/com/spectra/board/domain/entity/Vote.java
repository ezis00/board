package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.VoteType;

public class Vote extends Entity
{
    private final PostInfo postInfo;
    private final VoteType voteType;
    private final long date;

    public Vote(PostInfo postInfo, VoteType voteType)
    {
        this.postInfo = postInfo;
        this.voteType = voteType;
        this.date = System.currentTimeMillis();
    }

    public PostInfo getPostInfo()
    {
        return postInfo;
    }

    public VoteType getVoteType()
    {
        return voteType;
    }

    public long getDate()
    {
        return date;
    }

    @Override
    public String toString()
    {
        return "Vote{" +
                "postInfo=" + postInfo +
                ", voteType=" + voteType +
                ", date=" + date +
                "} " + super.toString();
    }
}
