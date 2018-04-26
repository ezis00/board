package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Vote;
import com.spectra.board.domain.spec.VoteService;
import com.spectra.board.domain.store.VoteStore;

public class VoteLogic implements VoteService
{
    private VoteStore voteStore;

    public VoteLogic(VoteStore voteStore)
    {
        this.voteStore = voteStore;
    }

    @Override
    public String register(Vote vote)
    {
        voteStore.create(vote);
        return vote.getId();
    }

    @Override
    public Vote find(String voteId)
    {
        return voteStore.retrieve(voteId);
    }
}
