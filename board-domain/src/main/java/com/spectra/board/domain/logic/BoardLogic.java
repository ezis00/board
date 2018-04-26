package com.spectra.board.domain.logic;

import java.util.List;

import com.spectra.board.domain.entity.board.Posting;
import com.spectra.board.domain.granule.PostInfo;
import com.spectra.board.domain.share.granule.NameValueList;
import com.spectra.board.domain.spec.BoardService;
import com.spectra.board.domain.store.BoardStore;

public class BoardLogic implements BoardService
{
    private BoardStore boardStore;

    public BoardLogic(BoardStore boardStore)
    {
        this.boardStore = boardStore;
    }

    @Override
    public String register(Posting posting)
    {
        boardStore.create(posting);
        return posting.getId();
    }

    @Override
    public Posting find(String boardId)
    {
        return boardStore.retrieve(boardId);
    }

    @Override
    public void modify(String boardId, NameValueList nameValueList)
    {
        Posting posting = find(boardId);
        posting.setValues(nameValueList);
        boardStore.update(posting);
    }

    @Override
    public List<Posting> findByParentPostInfo(PostInfo postInfo)
    {
        return boardStore.retrieveByParentPostInfo(postInfo);
    }
}
