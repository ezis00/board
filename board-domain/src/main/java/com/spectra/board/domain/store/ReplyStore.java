package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.Reply;

public interface ReplyStore
{
    void create(Reply reply);

    Reply retrieve(String replyId);

    void update(Reply reply);
}
