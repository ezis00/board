package com.spectra.board.domain.entity;

import com.spectra.board.domain.granule.NameValue;
import com.spectra.board.domain.granule.NameValueList;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;
import com.spectra.board.domain.granule.VoteType;

public class Vote extends Post
{
    private final PostType postType = PostType.BOARD;
    private VoteType voteType;

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
            String value = nameValue.getValue();
            switch (nameValue.getName())
            {
                case "voteType":
                    this.voteType = VoteType.fromJson(value);
                    break;
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
}
