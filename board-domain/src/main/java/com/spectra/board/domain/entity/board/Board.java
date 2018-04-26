package com.spectra.board.domain.entity.board;

import java.util.Optional;

import com.spectra.board.domain.entity.Entity;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public abstract class Board extends Entity
{
    private final Optional<PostInfo> parentPostInfo;
    private final String writerId;
    private final long postDate;

    public Board(PostInfo parentPostInfo, String writerId)
    {
        this.parentPostInfo = Optional.ofNullable(parentPostInfo);
        this.writerId = writerId;
        this.postDate = System.currentTimeMillis();
    }

    public Board(String id, PostInfo parentPostInfo, String writerId)
    {
        super(id);
        this.parentPostInfo = Optional.ofNullable(parentPostInfo);
        this.writerId = writerId;
        this.postDate = System.currentTimeMillis();
    }

    public PostInfo getParentPostInfo()
    {
        return parentPostInfo.orElse(null);
    }

    public String getWriterId()
    {
        return writerId;
    }

    public long getPostDate()
    {
        return postDate;
    }

    public abstract PostType getPostType();

    public PostInfo getCurrentPostInfo()
    {
        return new PostInfo(getPostType(), getId());
    }

    @Override
    public String toString()
    {
        return "Board{" +
                "parentPostInfo=" + parentPostInfo +
                ", writerId='" + writerId + '\'' +
                ", postDate=" + postDate +
                "} " + super.toString();
    }
}
