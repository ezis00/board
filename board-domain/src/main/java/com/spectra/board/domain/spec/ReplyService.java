package com.spectra.board.domain.spec;

import java.util.List;

import com.spectra.board.domain.entity.Reply;
import com.spectra.board.domain.granule.NameValueList;

public interface ReplyService
{
    String register(Reply reply);

    Reply find(String replyId);

    void modify(String replyId, NameValueList nameValueList);
}
