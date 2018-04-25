package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Reply;
import com.spectra.board.domain.store.ReplyStore;

public class ReplyMapStore implements ReplyStore
{
    private Map<String, Reply> map;

    public ReplyMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Reply reply)
    {
        this.map.put(reply.getId(), reply);
    }

    @Override
    public Reply retrieve(String replyId)
    {
        return this.map.get(replyId);
    }

    @Override
    public void update(Reply reply)
    {
        this.map.put(reply.getId(), reply);
    }
}
