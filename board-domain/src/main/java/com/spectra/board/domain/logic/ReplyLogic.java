package com.spectra.board.domain.logic;

import java.util.List;

import com.spectra.board.domain.granule.NameValueList;

public class ReplyLogic implements PostService
{
    private PostStore postStore;

    public ReplyLogic(PostStore postStore)
    {
        this.postStore = postStore;
    }

    @Override
    public String register(Post post)
    {
        postStore.create(post);
        return post.getId();
    }

    @Override
    public Post find(String postId)
    {
        return postStore.retrieve(postId);
    }

    @Override
    public List<Post> findByChannelName(String channelName)
    {
        return postStore.retrieveByChannelName(channelName);
    }

    @Override
    public void modify(String postId, NameValueList nameValueList)
    {
        Post post = find(postId);
        post.setValues(nameValueList);
        postStore.update(post);
    }
}
