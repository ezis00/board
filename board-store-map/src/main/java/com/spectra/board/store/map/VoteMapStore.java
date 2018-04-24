package com.spectra.board.store.map;

import java.util.HashMap;
import java.util.Map;

import com.spectra.board.domain.entity.Vote;
import com.spectra.board.domain.store.VoteStore;

public class VoteMapStore implements VoteStore
{
    private Map<String, Vote> map;

    public VoteMapStore()
    {
        this.map = new HashMap<>();
    }

    @Override
    public void create(Vote vote)
    {
        this.map.put(vote.getId(), vote);
    }

    @Override
    public Vote retrieve(String voteId)
    {
        return this.map.get(voteId);
    }

    @Override
    public void update(Vote vote)
    {
        this.map.put(vote.getId(), vote);
    }
}
