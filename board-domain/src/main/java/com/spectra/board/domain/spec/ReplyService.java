package com.spectra.board.domain.spec;

import com.spectra.board.domain.entity.Reply;
import com.spectra.board.domain.share.granule.NameValueList;

public interface ReplyService
{
    String register(Reply reply);

    Reply find(String replyId);

    void modify(String replyId, NameValueList nameValueList);
}
