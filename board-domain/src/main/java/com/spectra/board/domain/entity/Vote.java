package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;
import com.spectra.board.domain.granule.VoteType;
import com.spectra.board.domain.share.granule.NameValue;
import com.spectra.board.domain.share.granule.NameValueList;

public class Vote extends Post
{
    private final PostType postType = PostType.BOARD;
    private final VoteType voteType;

    public Vote(PostInfo parentPostInfo, String writerId, VoteType voteType)
    {
        super(parentPostInfo, writerId);
        this.voteType = voteType;
    }

    public VoteType getVoteType()
    {
        return voteType;
    }

    @Override
    public PostType getPostType()
    {
        return this.postType;
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

    @Override
    public String toString()
    {
        return "Vote{" +
                "voteType=" + voteType +
                "} " + super.toString();
    }

    public static Vote getSample()
    {
        return new Vote(Board.getNotifySample().getCurrentPostInfo(), User.getAdminSample().getId(), VoteType.HAPPY);
    }
}
