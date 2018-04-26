package com.spectra.board.domain.granule;

import com.spectra.share.util.JsonUtil;

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

    public static PostInfo fromJson(String value)
    {
        return JsonUtil.fromJson(value, PostInfo.class);
    }

    public static String toJson(PostInfo object)
    {
        return JsonUtil.toJson(object);
    }

    @Override
    public String toString()
    {
        return "PostInfo{" +
                "postType=" + postType +
                ", postId='" + postId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostInfo postInfo = (PostInfo) o;

        if (postType != postInfo.postType) return false;
        return postId != null ? postId.equals(postInfo.postId) : postInfo.postId == null;
    }

    @Override
    public int hashCode()
    {
        int result = postType != null ? postType.hashCode() : 0;
        result = 31 * result + (postId != null ? postId.hashCode() : 0);
        return result;
    }
}
