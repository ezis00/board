package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Post;
import com.spectra.board.domain.store.PostStore;

public class PostMapStore implements PostStore
{
    private Map<String, Post> map;

    public PostMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Post post)
    {
        this.map.put(post.getId(), post);
    }

    @Override
    public Post retrieve(String postId)
    {
        return this.map.get(postId);
    }

    @Override
    public void update(Post post)
    {
        this.map.put(post.getId(), post);
    }
}
