package com.spectra.board.domain.granule;

public class ParentPost
{
    private PostType postType;
    private String postId;

    public ParentPost(PostType postType, String postId)
    {
        this.postType = postType;
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

    public String getPostId()
    {
        return postId;
    }

    public void setPostId(String postId)
    {
        this.postId = postId;
    }

    @Override
    public String toString()
    {
        return "ParentPost{" +
                "postType=" + postType +
                ", postId='" + postId + '\'' +
                '}';
    }
}
