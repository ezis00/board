package com.spectra.board.domain.granule;

public class PostInfo
{
    private final PostType postType;
    private final String postId;

    public PostInfo(PostType postType, String postId)
    {
        this.postType = postType;
        this.postId = postId;
    }

    public PostType getPostType()
    {
        return postType;
    }

    public String getPostId()
    {
        return postId;
    }

    @Override
    public String toString()
    {
        return "PostInfo{" +
                "postType=" + postType +
                ", postId='" + postId + '\'' +
                '}';
    }
}
