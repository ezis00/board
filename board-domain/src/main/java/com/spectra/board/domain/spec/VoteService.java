package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.board.Vote;

public interface VoteService
{
    String register(Vote vote);

    Vote find(String voteId);
}
