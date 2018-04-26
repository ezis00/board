package com.spectra.board.domain.store;

import com.spectra.board.domain.entity.board.Comment;

public interface ReplyStore
{
    void create(Comment comment);

    Comment retrieve(String replyId);

    void update(Comment comment);
}
