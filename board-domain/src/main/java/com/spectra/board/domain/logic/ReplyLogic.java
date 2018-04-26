package com.spectra.board.domain.logic;

import com.spectra.board.domain.entity.board.Comment;
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
    public String register(Comment comment)
    {
        replyStore.create(comment);
        return comment.getId();
    }

    @Override
    public Comment find(String replyId)
    {
        return replyStore.retrieve(replyId);
    }

    @Override
    public void modify(String replyId, NameValueList nameValueList)
    {
        Comment comment = find(replyId);
        comment.setValues(nameValueList);
        replyStore.update(comment);
    }
}
