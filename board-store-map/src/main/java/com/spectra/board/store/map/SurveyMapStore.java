package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SurveyMapStore implements PostStore
{
    private Map<String, Post> map;

    public SurveyMapStore()
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
    public List<Post> retrieveByChannelName(String channelName)
    {
        return this.map.values().stream().filter(channel -> ch);
    }

    @Override
    public void update(Post post)
    {
        this.map.put(post.getId(), post);
    }
}
