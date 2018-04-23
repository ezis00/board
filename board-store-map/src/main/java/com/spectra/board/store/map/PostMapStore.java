package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Post;
import com.spectra.board.domain.store.PostStore;

public class PostMapStore implements PostStore
{
    private Map<String, Post> postMap;

    public PostMapStore()
    {
        this.postMap = new HashMap<>();
    }

    @Override
    public Post retrieveByTitle(String title)
    {
        return this.postMap.values().stream().filter(post -> post.getTitle().equals(title)).findFirst().orElse(null);
    }

    @Override
    public void create(Post post)
    {
        this.postMap.put(post.getId(), post);
    }

    @Override
    public Post retrieve(String postId)
    {
        return this.postMap.get(postId);
    }

    @Override
    public void update(Post post)
    {
        this.postMap.put(post.getId(), post);
    }
}
