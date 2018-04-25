package com.spectra.board.domain.entity;

import java.util.Optional;

import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.granule.PostType;

public abstract class Post extends Entity
{
    private final Optional<PostInfo> parentPostInfo;
    private final String writerId;
    private final long postDate;

    public Post(PostInfo parentPostInfo, String writerId)
    {
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
        return "Post{" +
                "parentPostInfo=" + parentPostInfo +
                ", writerId='" + writerId + '\'' +
                ", postDate=" + postDate +
                "} " + super.toString();
    }
}
