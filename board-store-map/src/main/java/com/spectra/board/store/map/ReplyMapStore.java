package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.board.Comment;
import com.spectra.board.domain.store.ReplyStore;

public class ReplyMapStore implements ReplyStore
{
    private Map<String, Comment> map;

    public ReplyMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Comment comment)
    {
        this.map.put(comment.getId(), comment);
    }

    @Override
    public Comment retrieve(String replyId)
    {
        return this.map.get(replyId);
    }

    @Override
    public void update(Comment comment)
    {
        this.map.put(comment.getId(), comment);
    }
}
