package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.board.Comment;
import com.spectra.board.domain.share.granule.NameValueList;

public interface ReplyService
{
    String register(Comment comment);

    Comment find(String replyId);

    void modify(String replyId, NameValueList nameValueList);
}
