package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Vote;

public interface VoteStore
{
    void create(Vote vote);

    Vote retrieve(String voteId);

    void update(Vote vote);
}
