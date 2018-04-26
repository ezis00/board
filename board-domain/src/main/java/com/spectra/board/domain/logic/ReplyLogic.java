package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.Reply;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.spec.ReplyService;
import com.spectra.board.domain.store.ReplyStore;

public class ReplyLogic implements ReplyService
{
    private ReplyStore replyStore;

    public ReplyLogic(ReplyStore replyStore)
    {
        this.replyStore = replyStore;
    }

    @Override
    public String register(Reply reply)
    {
        replyStore.create(reply);
        return reply.getId();
    }

    @Override
    public Reply find(String replyId)
    {
        return replyStore.retrieve(replyId);
    }

    @Override
    public void modify(String replyId, NameValueList nameValueList)
    {
        Reply reply = find(replyId);
        reply.setValues(nameValueList);
        replyStore.update(reply);
    }
}
